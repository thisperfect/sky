package com.xmbl.ops.service.house;


import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.xmbl.ops.dao.house.IBaseHouseDao;
import com.xmbl.ops.dao.organization.impl.UserInfoDaoImpl;
import com.xmbl.ops.model.house.BaseHouse;
import com.xmbl.ops.model.organization.UserInfo;
import com.xmbl.ops.enumeration.EnumOfficeTag;
import com.xmbl.ops.enumeration.EnumHouseType;
import com.xmbl.ops.enumeration.EnumHouseSourceType;
import com.xmbl.ops.enumeration.EnumIsKey;
import com.xmbl.ops.enumeration.EnumTradeType;
import com.xmbl.ops.enumeration.EnumSeeMethod;
import com.xmbl.ops.enumeration.EnumHouseRentalPriceType;
import com.xmbl.ops.enumeration.EnumHousePaymentMethod;
import com.xmbl.ops.enumeration.EnumHouseOrientation;
import com.xmbl.ops.enumeration.EnumHouseStatus;
import com.xmbl.ops.enumeration.EnumHouseIsstatus;
import com.xmbl.ops.enumeration.EnumHouseDiskstatus;
import com.xmbl.ops.enumeration.EnumHouseSealingdisk;


@Service
public class BaseHouseService {

	@Resource
	IBaseHouseDao baseHouseDao;
	@Resource
	UserInfoDaoImpl userInfoDao;
	
	
	
	private void setEnumHouseDiskstatus(BaseHouse baseHouse) {
		Integer sealingdisk = baseHouse.getRentalpricetype();
    	if(sealingdisk != null) {
    		for(EnumHouseDiskstatus EnumHouseDiskstatuss : EnumHouseDiskstatus.values()) {
    			if(sealingdisk.equals(Integer.valueOf(EnumHouseDiskstatuss.getId()))) {
    				baseHouse.setDiskstatusStr(EnumHouseDiskstatuss.getDesc());
    				break;
    			}
    		}
    	}
    }
	
	private void setEnumHouseIsstatus(BaseHouse baseHouse) {
		Integer isstatus = baseHouse.getIsstatus();
    	if(isstatus != null) {
    		for(EnumHouseIsstatus EnumHouseIsstatuss : EnumHouseIsstatus.values()) {
    			if(isstatus.equals(Integer.valueOf(EnumHouseIsstatuss.getId()))) {
    				baseHouse.setIsstatusStr(EnumHouseIsstatuss.getDesc());
    				break;
    			}
    		}
    	}
    }
	
	
	private void setEnumHouseSealingdisk(BaseHouse baseHouse) {
		Integer sealingdisk = baseHouse.getSealingdisk();
    	if(sealingdisk != null) {
    		for(EnumHouseSealingdisk EnumHouseSealingdisks : EnumHouseSealingdisk.values()) {
    			if(sealingdisk.equals(Integer.valueOf(EnumHouseSealingdisks.getId()))) {
    				baseHouse.setSealingdiskStr(EnumHouseSealingdisks.getDesc());
    				break;
    			}
    		}
    	}
    }
	
	private void setEnumHouseStatus(BaseHouse baseHouse) {
		Integer housestatus = baseHouse.getHousestatus();
    	if(housestatus != null) {
    		for(EnumHouseStatus EnumHouseStatuss : EnumHouseStatus.values()) {
    			if(housestatus.equals(Integer.valueOf(EnumHouseStatuss.getId()))) {
    				baseHouse.setHousestatusStr(EnumHouseStatuss.getDesc());
    				break;
    			}
    		}
    	}
    }
	
	private void setEnumOfficeTag(BaseHouse baseHouse) {
		if(StringUtils.isNotEmpty(baseHouse.getOfficetag())) {
		String[] OfficetagId = baseHouse.getOfficetag().split(",");
		StringBuffer buff = new StringBuffer();
		for(String i:OfficetagId){
			if(StringUtils.isNotEmpty(i)){ 
				for(EnumOfficeTag OfficeTags : EnumOfficeTag.values()) {
	    			if(i.equals(OfficeTags.getId()+"")) {
	    				buff.append(OfficeTags.getDesc()).append(',');
	    				break;
	    			}
	    		}	
			}
		}
		//去掉最后一个逗号
		if(buff.toString().length()>0){
			baseHouse.setOfficetag(buff.toString().substring(0,buff.toString().length()-1));				
		}else
		{
			baseHouse.setOfficetag(buff.toString());
		}
	  }
    }
	private void setEnumHouseRentalPriceType(BaseHouse baseHouse) {
		Integer RentalPriceType = baseHouse.getRentalpricetype();
    	if(RentalPriceType != null) {
    		for(EnumHouseRentalPriceType RentalPriceTypes : EnumHouseRentalPriceType.values()) {
    			if(RentalPriceType.equals(Integer.valueOf(RentalPriceTypes.getId()))) {
    				baseHouse.setRentalpricetypeStr(RentalPriceTypes.getDesc());
    				break;
    			}
    		}
    	}
    }
	private void setEnumHouseOrientation(BaseHouse baseHouse) {
		String Orientation = baseHouse.getOrientation();
    	if(Orientation != null) {
    		for(EnumHouseOrientation Orientations : EnumHouseOrientation.values()) {
    			if(Orientation.equals(Orientations.getId()+ "")) {
    				baseHouse.setOrientation(Orientations.getDesc());
    				break;
    			}
    		}
    	}
    }
	
	private void setEnumHousePaymentMethod(BaseHouse baseHouse) {
		String HousePaymentMethod = baseHouse.getPaymentmethod();
    	if(HousePaymentMethod != null) {
    		for(EnumHousePaymentMethod HousePaymentMethods : EnumHousePaymentMethod.values()) {
    			if(HousePaymentMethod.equals(HousePaymentMethods.getId()+ "")) {
    				baseHouse.setPaymentmethod(HousePaymentMethods.getDesc());
    				break;
    			}
    		}
    	}
    }
	
	private void setEnumSeeMethod(BaseHouse baseHouse) {
		String SeeMethod = baseHouse.getSeemethod();
    	if(SeeMethod != null) {
    		for(EnumSeeMethod SeeMethods : EnumSeeMethod.values()) {
    			if(SeeMethod.equals(SeeMethods.getId()+ "")) {
    				baseHouse.setSeemethod(SeeMethods.getDesc());
    				break;
    			}
    		}
    	}
    }
	private void setEnumHouseSourceType(BaseHouse baseHouse) {
		String Source = baseHouse.getSource();
    	if(Source != null) {
    		for(EnumHouseSourceType Sources : EnumHouseSourceType.values()) {
    			if(Source.equals(Sources.getId()+ "")) {
    				baseHouse.setSource(Sources.getDesc());
    				break;
    			}
    		}
    	}
    }
	private void setEnumType(BaseHouse baseHouse) {
		Integer Type = baseHouse.getType();
    	if(Type != null) {
    		for(EnumHouseType Types : EnumHouseType.values()) {
    			if(Type.equals(Types.getId())) {
    				baseHouse.setTypeStr(Types.getDesc());
    				break;
    			}
    		}
    	}
    }
	private void setEnumTradeType(BaseHouse baseHouse) {
		Integer TradeType = baseHouse.getTradetype();
    	if(TradeType != null) {
    		for(EnumTradeType TradeTypes : EnumTradeType.values()) {
    			if(TradeType.equals(TradeTypes.getId())) {
    				baseHouse.setTradetypeStr(TradeTypes.getDesc());
    				break;
    			}
    		}
    	}
    }
	private void setEnumIsKey(BaseHouse baseHouse) {
		String IsKey = baseHouse.getIskey();
    	if(IsKey != null) {
    		for(EnumIsKey IsKeys : EnumIsKey.values()) {
    			if(IsKey.equals(IsKeys.getId()+"")) {
    				baseHouse.setIskey(IsKeys.getDesc());
    				break;
    			}
    		}
    	}
    }
	private void setUserName(BaseHouse baseHouse) {
		String usename = baseHouse.getOperator();
    	if(usename != null) {
    		UserInfo userInfo = userInfoDao.selectOneByUserKey(usename);
    	    if(userInfo != null){
    	    	baseHouse.setOperatorName(userInfo.getUserName());
    	    }
    	}
    }
	
	private void setFounderName(BaseHouse baseHouse) {
		String usename = baseHouse.getFounder();
    	if(usename != null) {
    		UserInfo userInfo = userInfoDao.selectOneByUserKey(usename);
    	    if(userInfo != null){
    	    	baseHouse.setFounderName(userInfo.getUserName());
    	    }
    	}
    }
	
	public List<BaseHouse> searchList(Long id,String title,Integer type,
		    String housename,Integer tradetype,Double price,
		    Double rental,Double unitprice,Integer rentalpricetype,
		    Integer floor,String room,Double acreage,String orientation,
		    String officetag,String officetype, String paymentmethod,
		    String seemethod,String source,String iskey,String remarks,
		    String founder,String owner,String ownerphone,
		    String propertycompany,String propertphone,String operator,Date startDate,Date endDate,
			Long page, int limit) {
		List<BaseHouse> baseHouseList = baseHouseDao.searchList( id,title, type,
			     housename, tradetype, price,
			     rental, unitprice, rentalpricetype,
			     floor, room, acreage, orientation,
			     officetag, officetype,  paymentmethod,
			     seemethod, source, iskey, remarks,
			     founder, owner, ownerphone,
			     propertycompany, propertphone,operator,startDate, endDate , page, limit);
		for(BaseHouse baseHouse: baseHouseList){
			setEnumIsKey(baseHouse);
			setEnumType(baseHouse);
			setEnumTradeType(baseHouse);
			setEnumHouseSourceType(baseHouse);
			setEnumHouseOrientation(baseHouse);
			setEnumHousePaymentMethod(baseHouse);
			setEnumSeeMethod(baseHouse);
			setEnumHouseRentalPriceType(baseHouse);
			setEnumOfficeTag(baseHouse);
			setUserName(baseHouse);
			setFounderName(baseHouse);
			
			setEnumHouseStatus(baseHouse);
			setEnumHouseSealingdisk(baseHouse);
			setEnumHouseIsstatus(baseHouse);
			setEnumHouseDiskstatus(baseHouse);
		}
		
		
		return baseHouseList;
	}
	
	public List<BaseHouse> searchList(Long id,String title,Integer type,
		    String housename,Integer tradetype,Double price,
		    Double rental,Double unitprice,Integer rentalpricetype,
		    Integer floor,String room,Double acreage,String orientation,
		    String officetag,String officetype, String paymentmethod,
		    String seemethod,String source,String iskey,String remarks,
		    String founder,String owner,String ownerphone,
		    String propertycompany,String propertphone,String operator,Date startDate,Date endDate,
		    Double startAcreage,Double endAcreage,Double startRental,Double endRental,
		    String housestatus,String isstatus,String diskstatus,String sealingdisk,
			Long page, int limit) {
		List<BaseHouse> baseHouseList = baseHouseDao.searchList( id,title, type,
			     housename, tradetype, price,
			     rental, unitprice, rentalpricetype,
			     floor, room, acreage, orientation,
			     officetag, officetype,  paymentmethod,
			     seemethod, source, iskey, remarks,
			     founder, owner, ownerphone,
			     propertycompany, propertphone,operator,startDate, endDate ,
			     startAcreage,endAcreage,startRental,endRental,housestatus,isstatus,diskstatus,sealingdisk, page, limit);
		for(BaseHouse baseHouse: baseHouseList){
			setEnumIsKey(baseHouse);
			setEnumType(baseHouse);
			setEnumTradeType(baseHouse);
			setEnumHouseSourceType(baseHouse);
			setEnumHouseOrientation(baseHouse);
			setEnumHousePaymentMethod(baseHouse);
			setEnumSeeMethod(baseHouse);
			setEnumHouseRentalPriceType(baseHouse);
			setEnumOfficeTag(baseHouse);
			setUserName(baseHouse);
			setFounderName(baseHouse);
			
			setEnumHouseStatus(baseHouse);
			setEnumHouseSealingdisk(baseHouse);
			setEnumHouseIsstatus(baseHouse);
			setEnumHouseDiskstatus(baseHouse);
		}
		
		
		return baseHouseList;
	}
	
		
	public long searchCount(Long id,String title,Integer type,
		    String housename,Integer tradetype,Double price,
		    Double rental,Double unitprice,Integer rentalpricetype,
		    Integer floor,String room,Double acreage,String orientation,
		    String officetag,String officetype, String paymentmethod,
		    String seemethod,String source,String iskey,String remarks,
		    String founder,String owner,String ownerphone,
		    String propertycompany,String propertphone,String operator,Date startDate,Date endDate) {
		return baseHouseDao.searchCount(id,title, type,
			     housename, tradetype, price,
			     rental, unitprice, rentalpricetype,
			     floor, room, acreage, orientation,
			     officetag, officetype,  paymentmethod,
			     seemethod, source, iskey, remarks,
			     founder, owner, ownerphone,
			     propertycompany, propertphone,operator,startDate, endDate);
	}
	
	
	public long searchCount(Long id,String title,Integer type,
		    String housename,Integer tradetype,Double price,
		    Double rental,Double unitprice,Integer rentalpricetype,
		    Integer floor,String room,Double acreage,String orientation,
		    String officetag,String officetype, String paymentmethod,
		    String seemethod,String source,String iskey,String remarks,
		    String founder,String owner,String ownerphone,
		    String propertycompany,String propertphone,String operator,Date startDate,Date endDate,
		    Double startAcreage,Double endAcreage,Double startRental,Double endRental,
		    String housestatus,String isstatus,String diskstatus,String sealingdisk) {
		return baseHouseDao.searchCount(id,title, type,
			     housename, tradetype, price,
			     rental, unitprice, rentalpricetype,
			     floor, room, acreage, orientation,
			     officetag, officetype,  paymentmethod,
			     seemethod, source, iskey, remarks,
			     founder, owner, ownerphone,
			     propertycompany, propertphone,operator,startDate, endDate,
			     startAcreage,endAcreage,startRental,endRental,housestatus,isstatus,diskstatus,sealingdisk);
	}
	
	public BaseHouse addBaseHouse(String title,Integer type,
		    String housename,Integer tradetype,Double price,
		    Double rental,Double unitprice,Integer rentalpricetype,
		    String floor,String room,Double acreage,String orientation,
		    String officetag,String officetype, String paymentmethod,
		    String seemethod,String source,String iskey,String remarks,
		    String image, Date createtime,Date updatetime,String operator,
		    String founder,String owner,String ownerphone,
		    String propertycompany,String propertphone,Integer housestatus,Integer properties,Integer status,Integer isfollow,Integer followsee,
		    Integer isstatus,Integer diskstatus, Integer sealingdisk) {
		BaseHouse baseHouseInfo = new BaseHouse(title, type,
			     housename, tradetype, price,
			     rental, unitprice, rentalpricetype,
			     floor, room, acreage, orientation,
			     officetag, officetype,  paymentmethod,
			     seemethod, source, iskey, remarks,
			     image,  createtime, updatetime, operator,
			     founder, owner, ownerphone,
			     propertycompany, propertphone, housestatus, properties, status, isfollow, followsee,
				   isstatus, diskstatus,  sealingdisk);
		return baseHouseDao.insertSelective(baseHouseInfo);
	}
	
	public int updateBaseHouse(Long id,String title,Integer type,
		    String housename,Integer tradetype,Double price,
		    Double rental,Double unitprice,Integer rentalpricetype,
		    String floor,String room,Double acreage,String orientation,
		    String officetag,String officetype, String paymentmethod,
		    String seemethod,String source,String iskey,String remarks,
		    String image, Date createtime,Date updatetime,String operator,
		    String founder,String owner,String ownerphone,
		    String propertycompany,String propertphone,Integer housestatus,Integer properties,Integer status,Integer isfollow,Integer followsee,
		    Integer isstatus,Integer diskstatus, Integer sealingdisk) {		
		BaseHouse baseHouseInfo = new BaseHouse(  id, title, type,
			     housename, tradetype, price,
			     rental, unitprice, rentalpricetype,
			     floor, room, acreage, orientation,
			     officetag, officetype,  paymentmethod,
			     seemethod, source, iskey, remarks,
			     image,  createtime, updatetime, operator,
			     founder, owner, ownerphone,
			     propertycompany, propertphone, housestatus, properties, status, isfollow, followsee,
				   isstatus, diskstatus,  sealingdisk);
		int count = baseHouseDao.updateIfNecessary(baseHouseInfo);
		return count;
	}
	
	public int deleteBaseHouse(Long id) {
		int count = baseHouseDao.deleteBaseHouse(id);
		return count;
	}
	
	public BaseHouse getById(Long id){
		BaseHouse baseHouseInfo = baseHouseDao.getById(id);
		return baseHouseInfo;
	}

	
}
