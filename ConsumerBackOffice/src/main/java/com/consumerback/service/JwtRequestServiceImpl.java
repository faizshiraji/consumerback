//package com.consumerback.service;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.consumerback.api.entities.JwtRequest;
//import com.consumerback.dao.JwtRequestDao;
//
//@Service
//public class JwtRequestServiceImpl implements JwtRequestService {
//
//	@Autowired
//	public JwtRequestDao jwtRequestDao;
//	
//	@Override
//	public List<JwtRequest> getJwtRequests() {
//		return jwtRequestDao.findAll();
//	}
//
//	@Override
//	public JwtRequest getJwtRequest(int idjwt_request) {
//		return jwtRequestDao.findById(idjwt_request).get();
//	}
//
//	@Override
//	public JwtRequest getJwtRequestByJwtUsername(String jwtUsername) {
//		return jwtRequestDao.findByJwtUsername(jwtUsername);
//	}
//
//	@Override
//	public JwtRequest addJwtRequest(JwtRequest jwtRequest) {
//		return jwtRequestDao.save(jwtRequest);
//	}
//
//	@Override
//	public JwtRequest updateJwtRequest(JwtRequest jwtRequest) {
//		return jwtRequestDao.save(jwtRequest);
//	}
//
//	@Override
//	public void deleteJwtRequest(int idjwt_request) {
//		JwtRequest jwtRequest = jwtRequestDao.getOne(idjwt_request);
//		jwtRequestDao.delete(jwtRequest);
//	}
//
//}
