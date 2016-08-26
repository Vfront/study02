package spring.mvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import spring.mvc.dto.FoodDTO;

@Repository
public class FoodDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private class MyMapper implements RowMapper<FoodDTO>{

		@Override
		public FoodDTO mapRow(ResultSet rs, int arg1) throws SQLException {
			FoodDTO dto = new FoodDTO();
			dto.setNum(rs.getInt("num"));
			dto.setName(rs.getString("name"));
			dto.setPrice(rs.getInt("price"));
			dto.setOrgname(rs.getString("orgname"));
			dto.setSysname(rs.getString("sysname"));
			dto.setRegdate(rs.getDate("regdate"));
			
			return dto;
		}
		
	}
	
	private MyMapper mapper = new MyMapper();
	
	public int insertOne(FoodDTO dto) {
		String sql = "insert into t_food values(t_food_seq.nextval, ?, ?, ?, ? , sysdate)";
		Object[] values = {dto.getName(), dto.getPrice(), dto.getOrgname(), dto.getSysname()};
		return jdbcTemplate.update(sql, values);
	}
	public List<FoodDTO> selectList() {

		return jdbcTemplate.query("select * from t_food order by num desc", mapper);
	}
	public FoodDTO selectOne(int num) {
		return jdbcTemplate.queryForObject("select * from t_food where num=?", new Object[]{num}, mapper);
	}
	public int updateOne(FoodDTO dto) {
		return jdbcTemplate.update("update t_food set name=?, price=?, orgname=?, sysname=?, regdate=sysdate where num=?",
				new Object[]{dto.getName(), dto.getPrice(), dto.getOrgname(), dto.getSysname(), dto.getNum()});
		
	}
	public int deleteOne(int num) {
		return jdbcTemplate.update("delete from t_food where num=?", new Object[]{num});
	}
}
