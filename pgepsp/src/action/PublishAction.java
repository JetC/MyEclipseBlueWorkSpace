package action;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import service.*;
import tools.Pager;
import model.*;

public class PublishAction extends ActionSupport {

	// 备份序列号
	private static final long serialVersionUID = -7282803158724016064L;

	// 这是依赖注入块
	public PictureService picSer;
	public PublishService pubSer;

	public void setPicSer(PictureService picSer) {
		this.picSer = picSer;
	}

	public void setPubSer(PublishService pubSer) {
		this.pubSer = pubSer;
	}

	// 这里是视图与控制器间的传值以及对应的get，set方法
	protected int id;
	protected String c_pc_name;//用于更新类名
	protected String c_po_name;//用于更新来源
	protected String[] str1;
	protected String[] str2;
	protected String upExtension;
	protected String key;
	protected Pager pager=new Pager();
	protected String method="";
	protected String researchType="/qkdd/research";
	protected String time;
	protected String ip;
	protected String lookingTime;
	protected String viewPreread;
	protected String viewDetail;

	public String getViewPreread() {
		return viewPreread;
	}

	public void setViewPreread(String viewPreread) {
		this.viewPreread = viewPreread;
	}

	public String getViewDetail() {
		return viewDetail;
	}

	public void setViewDetail(String viewDetail) {
		this.viewDetail = viewDetail;
	}

	public String getLookingTime() {
		return lookingTime;
	}

	public void setLookingTime(String lookingTime) {
		this.lookingTime = lookingTime;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getResearchType() {
		return researchType;
	}

	public void setResearchType(String researchType) {
		this.researchType = researchType;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public Pager getPager() {
		return pager;
	}

	public void setPager(Pager pager) {
		this.pager = pager;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getC_pc_name() {
		return c_pc_name;
	}

	public void setC_pc_name(String c_pc_name) {
		this.c_pc_name = c_pc_name;
	}

	public String getC_po_name() {
		return c_po_name;
	}

	public void setC_po_name(String c_po_name) {
		this.c_po_name = c_po_name;
	}

	public String[] getStr1() {
		return str1;
	}

	public void setStr1(String[] str1) {
		this.str1 = str1;
	}

	public String[] getStr2() {
		return str2;
	}

	public void setStr2(String[] str2) {
		this.str2 = str2;
	}

	public String getUpExtension() {
		return upExtension;
	}

	public void setUpExtension(String upExtension) {
		this.upExtension = upExtension;
	}

	protected PublishRead pubReaUp;
	protected PublishClass pubCla;
	protected PublishOrigin pubOri;
	protected PublishRead pubRea;
	protected Picture pic;
	protected File file;
	protected String fileFileName;
	protected String fileContentType;
	protected List<PublishClass> pubClaList;
	protected List<PublishOrigin> pubOriList;
	protected List<PublishRead> pubReaList;
	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}
	public PublishRead getPubReaUp() {
		return pubReaUp;
	}

	public void setPubReaUp(PublishRead pubReaUp) {
		this.pubReaUp = pubReaUp;
	}

	public List<PublishClass> getPubClaList() {
		return pubClaList;
	}

	public void setPubClaList(List<PublishClass> pubClaList) {
		this.pubClaList = pubClaList;
	}

	public List<PublishOrigin> getPubOriList() {
		return pubOriList;
	}

	public void setPubOriList(List<PublishOrigin> pubOriList) {
		this.pubOriList = pubOriList;
	}

	public List<PublishRead> getPubReaList() {
		return pubReaList;
	}

	public void setPubReaList(List<PublishRead> pubReaList) {
		this.pubReaList = pubReaList;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public Picture getPic() {
		return pic;
	}

	public void setPic(Picture pic) {
		this.pic = pic;
	}

	public PublishClass getPubCla() {
		return pubCla;
	}

	public void setPubCla(PublishClass pubCla) {
		this.pubCla = pubCla;
	}

	public PublishOrigin getPubOri() {
		return pubOri;
	}

	public void setPubOri(PublishOrigin pubOri) {
		this.pubOri = pubOri;
	}

	public PublishRead getPubRea() {
		return pubRea;
	}

	public void setPubRea(PublishRead pubRea) {
		this.pubRea = pubRea;
	}

	public PictureService getPicSer() {
		return picSer;
	}

	public PublishService getPubSer() {
		return pubSer;
	}

	// 这是分类增查删改
	public String publishClassForm() {
		return "pcform";
	}

	public String addPublishClass() throws InterruptedException {
		pubSer.addPc(pubCla);
		return "pclist";
	}

	public String viewPc() {
		pubClaList = pubSer.viewPc();
		return "pclistview";
	}

	public String delPc() {
		if (pubSer.findPc(id) != null) {
			pubCla = pubSer.findPc(id);
			pubSer.deletePc(pubCla);
		}
		pubClaList = pubSer.viewPc();
		return "pclist";
	}

	public String updPcForm() {
		pubCla = pubSer.findPc(id);
		return "uppcform";
	}

	public String updPc() throws InterruptedException {
		pubCla = pubSer.findPc(id);
		pubCla.setPc_name(c_pc_name);
		pubSer.updatePc(pubCla);
		return "pclist";
	}

	// 这是来源增查删改
	public String publishOriginForm() {
		return "poform";
	}

	public String addPublishOrigin() throws InterruptedException {
		pubSer.addPo(pubOri);
		return "polist";
	}

	public String viewPo() {
		pubOriList = pubSer.viewPo();
		return "polistview";
	}

	public String delPo() {
		if (pubSer.findPo(id) != null) {
			pubOri = pubSer.findPo(id);
			pubSer.deletePo(pubOri);
		}
		pubOriList = pubSer.viewPo();
		return "polist";
	}

	public String updPoForm() {
		pubOri = pubSer.findPo(id);
		return "uppoform";
	}

	public String updPo() throws InterruptedException {
		pubOri = pubSer.findPo(id);
		pubOri.setPo_name(c_po_name);
		pubSer.updatePo(pubOri);
		return "polist";
	}

	// 这是导读文章增查删改
	public String publishReadForm() {
		pubClaList = pubSer.viewPc();
		pubOriList = pubSer.viewPo();
		str1 = new String[pubClaList.size()];
		str2 = new String[pubOriList.size()];
		for (int i = 0; i < pubClaList.size(); i++) {
			str1[i] = pubClaList.get(i).getPc_name();
		}
		for (int i = 0; i < pubOriList.size(); i++) {
			str2[i] = pubOriList.get(i).getPo_name();
		}
		return "prform";
	}

	public String addPublishRead() throws IOException, InterruptedException {
		Date now1 = new Date();
		Date date1 = new Date(now1.getTime());
		pubRea.setP_addtime(date1);
		pubRea.setP_count(20);
		pubRea.setP_person(1);
		pubRea.setP_templateId(1);
		int a = pubSer.addPr(pubRea);
		if (file != null) {
			FileInputStream fin;
			fin = new FileInputStream(file);
			byte[] pic_byte = new byte[(int) fin.available()];
			fin.read(pic_byte);
			fin.close();
			pic.setP_picture(pic_byte);
			pic.setFk_pid(a);
			pic.setP_extension(fileContentType);
			picSer.addPic(pic);
		}
		id=a;
		if(picSer.findPicList("from Picture where Fk_pid='"+id+"'").size()<=1){
			pic = picSer.findPic(a);
			detailComposing();
			if(pic!=null){
				return "prdetail";}
			else{return "prdetail2";}
		}
		else {return "prdetail3";}
	}
	public void validateAddPublishRead(){
		pubClaList = pubSer.viewPc();
		pubOriList = pubSer.viewPo();
		str1 = new String[pubClaList.size()];
		str2 = new String[pubOriList.size()];
		for (int i = 0; i < pubClaList.size(); i++) {
			str1[i] = pubClaList.get(i).getPc_name();
		}
		for (int i = 0; i < pubOriList.size(); i++) {
			str2[i] = pubOriList.get(i).getPo_name();
		}
		if(pubRea.getP_title()==null||pubRea.getP_title().trim().equals("")){
			addFieldError(pubRea.getP_title(),"标题不可为空");
		}
		if(pubRea.getP_preread()==null||pubRea.getP_preread().trim().equals("")){
			addFieldError(pubRea.getP_title(),"导读不可为空");
		}
		if(pubRea.getP_detail()==null||pubRea.getP_detail().trim().equals("")){
			addFieldError(pubRea.getP_title(),"文章内容不可为空");
		}
		if(pubRea.getP_title().trim().length()>30){
			addFieldError(pubRea.getP_title(),"标题不可超过30个字");
		}
		if(pubRea.getP_preread().trim().length()>200){
			addFieldError(pubRea.getP_title(),"标题不可超过200个字");
		}
	}

	public String viewPr() {
		int max = pubSer.viewPr().size();
		pager.setMaxRecords(max);
		paging();
		pubReaList=pubSer.viewPrByList(pager.getOffset(),pager.getPageSize());
		pubOriList = pubSer.viewPo();
		pubClaList = pubSer.viewPc();
		return "prlistview";
	}

	public String viewPrDetail() {
		pubRea = pubSer.findPr(id);
		if(pubRea==null){
			return "none";
		}
		if(pubRea!=null){
		pubRea.setP_count(pubRea.getP_count() + 1);
		pubSer.updatePr(pubRea);
		detailComposing();
		}
		if(picSer.findPicList("from Picture where Fk_pid='"+id+"'").size()<=1){
		pic = picSer.findPic(id);
			if(pic!=null){
				return "prdetail";}
			else {return "prdetail2";}
			}
		else {return "prdetail3";}
	}

	public String delPr() {
		pubRea = pubSer.findPr(id);
		pubClaList = pubSer.viewPc();
		pubOriList = pubSer.viewPo();
		if (pubSer.findPr(id) != null) {
			pubSer.deletePr(pubRea);
			if (picSer.findPic(id) != null) {
				pic = picSer.findPic(id);
				picSer.deletePic(pic);
			}
		}
		int max = pubSer.viewPr().size();
		pager.setMaxRecords(max);
		paging();
		pubReaList=pubSer.viewPrByList(pager.getOffset(),pager.getPageSize());
		return "prlist";
	}

	public String updPrForm() {
		pubRea = pubSer.findPr(id);
		pubClaList = pubSer.viewPc();
		pubOriList = pubSer.viewPo();
		str1 = new String[pubClaList.size()];
		str2 = new String[pubOriList.size()];
		for (int i = 0; i < pubClaList.size(); i++) {
			str1[i] = pubClaList.get(i).getPc_name();
		}
		for (int i = 0; i < pubOriList.size(); i++) {
			str2[i] = pubOriList.get(i).getPo_name();
		}
		return "upprform";
	}

	public String updPr() throws IOException{
		pubRea = pubSer.findPr(id);
		Date now1 = new Date();
		Date date1 = new Date();
		date1.setTime(now1.getTime());
		pubRea.setP_addtime(date1);
		pubRea.setP_title(pubReaUp.getP_title());
		pubRea.setP_author(pubReaUp.getP_author());
		pubRea.setP_type(pubReaUp.getP_type());
		pubRea.setP_from(pubReaUp.getP_from());
		pubRea.setP_preread(pubReaUp.getP_preread());
		pubRea.setP_detail(pubReaUp.getP_detail());
		pubRea.setP_link(pubReaUp.getP_link());
		pubRea.setP_originTime(pubReaUp.getP_originTime());
		pubSer.updatePr(pubRea);
		if(picSer.findPicList("from Picture where Fk_pid='"+id+"'").size()<=1){
			pic = picSer.findPic(id);
			if (file != null) {
				FileInputStream fin;
				fin = new FileInputStream(file);
				byte[] pic_byte = new byte[(int) fin.available()];
				fin.read(pic_byte);
				fin.close();
				if (pic != null) {
					pic.setP_picture(pic_byte);
					pic.setP_extension(upExtension);
					pic.setP_extension(fileContentType);
					picSer.updatePic(pic);
				} else {
					pic = new Picture();
					pic.setP_picture(pic_byte);
					pic.setP_extension(upExtension);
					pic.setP_extension(fileContentType);
					pic.setFk_pid(id);
					picSer.addPic(pic);
				}
			}
		}
		pubRea = pubSer.findPr(id);
		detailComposing();
		if(picSer.findPicList("from Picture where Fk_pid='"+id+"'").size()<=1){
			pic = picSer.findPic(id);
			if(pic!=null){
				return "prdetail";}
			else{return "prdetail2";}
		}
		else{return "prdetail3";}
	}
	
	public void validateUpdPr(){
		pubClaList = pubSer.viewPc();
		pubOriList = pubSer.viewPo();
		str1 = new String[pubClaList.size()];
		str2 = new String[pubOriList.size()];
		for (int i = 0; i < pubClaList.size(); i++) {
			str1[i] = pubClaList.get(i).getPc_name();
		}
		for (int i = 0; i < pubOriList.size(); i++) {
			str2[i] = pubOriList.get(i).getPo_name();
		}
		if(pubReaUp.getP_title()==null||pubReaUp.getP_title().trim().equals("")){
			addFieldError(pubReaUp.getP_title(),"标题不可为空");
		}
		if(pubReaUp.getP_preread()==null||pubReaUp.getP_preread().trim().equals("")){
			addFieldError(pubReaUp.getP_title(),"导读不可为空");
		}
		if(pubReaUp.getP_detail()==null||pubReaUp.getP_detail().trim().equals("")){
			addFieldError(pubReaUp.getP_title(),"文章内容不可为空");
		}
		if(pubReaUp.getP_title().trim().length()>30){
			addFieldError(pubReaUp.getP_title(),"标题不可超过30个字");
		}
		if(pubReaUp.getP_preread().trim().length()>200){
			addFieldError(pubReaUp.getP_title(),"标题不可超过200个字");
		}
		pubRea = pubSer.findPr(id);
	}

	// 这是图片显示的方法
	public String viewPicture() {
		if(picSer.findPicList("from Picture where Fk_pid='"+id+"'").size()<=1){
			pic = picSer.findPic(id);
			if (pic != null) {
				byte[] pic_byte = pic.getP_picture();
				ActionContext.getContext().getSession().put("pic", pic_byte);
				return "pic";
				} else {
				return null;
				}
		}
		else{
			return null;
		}
	}

	// 文章格式排版方法
	public void detailComposing() {
		if(pubRea.getP_detail()==null){
			return;
		}
		viewDetail=pubRea.getP_detail();
		String[] divide = viewDetail.split("　");
		String combine = "";
		for (int i = 0; i < divide.length; i++) {
			if (!(divide[i].equals(""))) {
				combine = combine + divide[i];
			}
		}
		divide = combine.split("\r\n");
		combine = "";
		for (int i = 0; i < divide.length; i++) {
			if (!(divide[i].equals(""))) {
				combine = combine + "<p>　　" + divide[i] + "</p>";
			}
		}
		combine=combine.trim();
		viewDetail=combine;
		divide = viewDetail.split("　");
		combine = "";
		for (int i = 0; i < divide.length; i++) {
			if (!(divide[i].equals(""))) {
				combine = combine + divide[i];
			}
		}
		viewDetail=combine;
		viewPreread=pubRea.getP_preread();
		divide = viewPreread.split("\r\n");
		combine = "";
		for (int i = 0; i < divide.length; i++) {
			if (!(divide[i].equals(""))) {
				combine = combine +"<p>　　"+ divide[i]+"</p>";
			}
		}
		combine=combine.trim();
		viewPreread=combine;
		//SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if(pubRea.getP_originTime()!=null){
		SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
		time=formatter.format(pubRea.getP_originTime());}
	}

//搜索方法（按标题搜索）
	public String research(){
		researchType="/qkdd/research";
		if(key==null||key.equals("")||key.equals(" ")){
			pubOriList = pubSer.viewPo();
			pubClaList = pubSer.viewPc();
			return "research";
		}
		int max = pubSer.research(key).size();
		pager.setMaxRecords(max);
		paging();
		pubReaList=pubSer.researchViewPrByList(pager.getOffset(),pager.getPageSize(),key);
		pubOriList = pubSer.viewPo();
		pubClaList = pubSer.viewPc();
		return "research";
	}
	
//按类型搜索
	public String classResearch(){
		researchType="/qkdd/classresearch";
		int max = pubSer.classResearch(key).size();
		pager.setMaxRecords(max);
		paging();
		pubReaList=pubSer.classResearchViewPrByList(pager.getOffset(),pager.getPageSize(),key);
		pubOriList = pubSer.viewPo();
		pubClaList = pubSer.viewPc();
		return "research";
	}

//按来源搜索
	public String originResearch(){
		researchType="/qkdd/originresearch";
		int max = pubSer.originResearch(key).size();
		pager.setMaxRecords(max);
		paging();
		pubReaList=pubSer.originResearchViewPrByList(pager.getOffset(),pager.getPageSize(),key);
		pubOriList = pubSer.viewPo();
		pubClaList = pubSer.viewPc();
		return "research";
	}
	
//将文章集合进行分页
	public void paging(){
		pager.setPageSize(9);
		pager=pubSer.pageInitial(pager, method);
	}

	
//前台的浏览方法
	public String findex() throws ParseException{
		pubClaList = pubSer.viewPc();
		pubOriList = pubSer.viewPo();
		int max = pubSer.viewPr().size();
		pager.setMaxRecords(max);
		paging();
		pubReaList=pubSer.viewPrByList(pager.getOffset(),pager.getPageSize());
		for(PublishRead pubRea:pubReaList){
			if(pubRea.getP_originTime()!=null){
				SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
				time=formatter.format(pubRea.getP_originTime());
				pubRea.setP_originTime(formatter.parse(time));
				}
		}
		return "index";
	}
	
	public String fdetail(){
		ip=getIpAddr(ServletActionContext.getRequest());
		pubClaList = pubSer.viewPc();
		pubOriList = pubSer.viewPo();
		pubRea = pubSer.findPr(id);
		pubRea.setP_count(pubRea.getP_count() + 1);
		pubSer.updatePr(pubRea);
		detailComposing();
		pic = picSer.findPic(id);
		if(pic!=null){
				return "detail";
		}
		else{return "detail2";}
	}
	
	public String fresearch(){
		pubClaList = pubSer.viewPc();
		pubOriList = pubSer.viewPo();
		researchType="/qkdd/fresearch";
		if(key==null||key.equals("")||key.equals(" ")){
			return "fresearch";
		}
		int max = pubSer.research(key).size();
		pager.setMaxRecords(max);
		paging();
		pubReaList=pubSer.researchViewPrByList(pager.getOffset(),pager.getPageSize(),key);
		return "fresearch";
	}
	
	public String fclassResearch(){
		pubClaList = pubSer.viewPc();
		pubOriList = pubSer.viewPo();
		researchType="/qkdd/fclass";
		int max = pubSer.classResearch(key).size();
		pager.setMaxRecords(max);
		paging();
		pubReaList=pubSer.classResearchViewPrByList(pager.getOffset(),pager.getPageSize(),key);
		return "fresearch";
	}
	
	public String foriginResearch(){
		pubClaList = pubSer.viewPc();
		pubOriList = pubSer.viewPo();
		researchType="/qkdd/forigin";
		int max = pubSer.originResearch(key).size();
		pager.setMaxRecords(max);
		paging();
		pubReaList=pubSer.originResearchViewPrByList(pager.getOffset(),pager.getPageSize(),key);
		return "fresearch";
	}
	
	//获取ip的方法
	public String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

	/*public String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}
	*/
}
