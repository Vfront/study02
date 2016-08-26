package spring.mvc.service;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import spring.mvc.dao.FoodDAO;
import spring.mvc.dto.FoodDTO;

@Service
public class FoodService extends DefaultTransactionDefinition{

	@Autowired
	private PlatformTransactionManager tx;
	private TransactionStatus status;
	@Autowired
	private FoodDAO dao;
	
	public void insertOne(FoodDTO dto) {
		status = tx.getTransaction(this);
		int res = dao.insertOne(dto);
		if(res>0) tx.commit(status);
		else tx.rollback(status);
		
	}

	public List<FoodDTO> selectList() {

		return dao.selectList();

	}

	public FoodDTO selectOne(int num) {
		
		return dao.selectOne(num);
	}

	public void updateOne(FoodDTO dto) {
		status = tx.getTransaction(this);
		int res = dao.updateOne(dto);
		if(res>0) tx.commit(status);
		else tx.rollback(status);
		
	}

	public void deleteOne(int num) {

		status = tx.getTransaction(this);
		FoodDTO dto = dao.selectOne(num);
		int res = dao.deleteOne(num);
		if(res>0){
			deletePic(dto.getSysname());
			tx.commit(status);
		} else {
			tx.rollback(status);	
		}
		
	}
	
	public void deletePic(String sysname){
		File ff = new File("D:\\Spring_workspace\\Food\\WebContent\\files\\"+sysname);
		if(ff.exists()) ff.delete();
	}
	
}
