package action;

import model.*;
import service.*;
import tools.Pager;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.List;
import java.util.TreeSet;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

public class HbsyAction{
	//环保术语字段
	private int id;
	private String e_name;
	private String e_abstract;
	private String e_detail;
	private Date e_addtime;
	private int e_count;
	private String e_type;
	protected Hbsy h;
	protected HbsyService hbsyservice;
	//图片字段(无ID)
	String p_title;
	String p_describe;
	String p_place;
	String p_type;
	private File file;
	private String fileFileName;
	private String fileContentType;
	byte[] p_picture;
	String p_extension;
	String p_templateId;
	int Fk_eId;
	String Person;
	protected Picture p;
	protected PictureService pictureservice;
//统计字段
	Statistics sta;
	StatisticsService statisticsservice;
	private String s_enterTime;
	private String s_closeTime;
	private String s_totalTime;
	private String s_ip;
	private String s_type;
	private int FK_id;

//辅助变量
	int num;
	int num2;
	String isFirst="";
	List<Hbsy> allList;
	Pager pager=new Pager();
	String method="";
	String word="";//搜索类型
	String keyword="";//搜索关键字
	String dateString="";
	List<Hbsy> typeList;
	String[] str1;
	String[] numRank;
	int[] numRankId;
// 以下是类对象的set和get
	public Hbsy getH() {
		return h;
	}
	public void setH(Hbsy h) {
		this.h = h;
	}
	public HbsyService getHbsyservice() {
		return hbsyservice;
	}
	public void setHbsyservice(HbsyService hbsyservice) {
		this.hbsyservice = hbsyservice;
	}
	public Picture getP() {
		return p;
	}
	public void setP(Picture p) {
		this.p = p;
	}
	public PictureService getPictureservice() {
		return pictureservice;
	}
	public void setPictureservice(PictureService pictureservice) {
		this.pictureservice = pictureservice;
	}

	// 以下是环保术语的字段
	public void setId(String id) {
		this.id = Integer.parseInt(id);
	}
	public int getId() {
		return this.id;
	}
	public void setE_name(String e_name) {
		this.e_name = e_name;
	}
	public String getE_name() {
		return this.e_name;
	}

	public void setE_abstract(String e_abstract) {
		this.e_abstract = e_abstract;
	}
	public String getE_abstract() {
		return this.e_abstract;
	}
	public void setE_detail(String e_detail) {
		this.e_detail = e_detail;
	}
	public String getE_detail() {
		return this.e_detail;
	}
	public void setE_addtime(Date e_addtime) {
		this.e_addtime = e_addtime;
	}
	public Date getE_addtime() {		
		return this.e_addtime;
	}
	public void setE_count(int e_count) {
		this.e_count = e_count;
	}
	public int getE_count() {
		return this.e_count;
	}
	public void setE_type(String e_type) {
		this.e_type = e_type;
	}
	public String getE_type() {
		return this.e_type;
	}

	// 以下是图片的字段
	public void setP_title(String p_title) {
		this.p_title = p_title;
	}

	public String getP_title() {
		return this.p_title;
	}
	public void setP_describe(String p_describe) {
		this.p_describe = p_describe;
	}
	public String getP_describe() {
		return this.p_describe;
	}
	public void setP_place(String p_place) {
		this.p_place = p_place;
	}
	public String getP_place() {
		return this.p_place;
	}
	public void setP_type(String p_type) {
		this.p_type = p_type;
	}
	public String getP_type() {
		return this.p_type;
	}
	public File getFile(){
		return file;
	}
	public void setFile(File file){
		this.file=file;
	}
	public void setFileFileName(String fileFileName){
		this.fileFileName=fileFileName;
	}
	public String getFileFileName(){
		return this.fileFileName;
	}
	public void setFileContentType(String fileContentType){
		this.fileContentType=fileContentType;
	}
	public String getFileContentType(){
		return this.fileContentType;
	}
	public void setP_picture(byte[] p_picture){
		this.p_picture=p_picture;
	}
	public byte[] getP_picture() {
		return this.p_picture;
	}
	public void setP_extension(String p_extension) {
		this.p_extension = p_extension;
	}
	public String getP_extension() {
		return this.p_extension;
	}
	public void setP_templateId(String p_templateId) {
		this.p_templateId = p_templateId;
	}
	public String getP_templateId() {
		return this.p_templateId;
	}
	public void setFk_eId(int Fk_eId) {
		this.Fk_eId = Fk_eId;
	}
	public int getFk_eId() {
		return this.Fk_eId;
	}
	public void setPerson(String Person) {
		this.Person = Person;
	}
	public String getPerson() {
		return this.Person;
	}
//统计字段
	public void setSta(Statistics sta){
		this.sta=sta;
	}
	public Statistics getSta(){
		return this.sta;
	}
	public void setStatisticsservice(StatisticsService statisticsservice){
		this.statisticsservice=statisticsservice;
	}
	public StatisticsService getStatisticsservice(){
		return this.statisticsservice;
	}
	public String getS_enterTime() {
		return s_enterTime;
	}
	public void setS_enterTime(String s_enterTime) {
		this.s_enterTime = s_enterTime;
	}
	public String getS_closeTime() {
		return s_closeTime;
	}
	public void setS_closeTime(String s_closeTime) {
		this.s_closeTime = s_closeTime;
	}
	public String getS_totalTime() {
		return s_totalTime;
	}
	public void setS_totalTime(String s_totalTime) {
		this.s_totalTime = s_totalTime;
	}
	public String getS_ip() {
		return s_ip;
	}
	public void setS_ip(String s_ip) {
		this.s_ip = s_ip;
	}
	public String getS_type() {
		return s_type;
	}
	public void setS_type(String s_type) {
		this.s_type = s_type;
	}
	public int getFK_id() {
		return FK_id;
	}
	public void setFK_id(int fK_id) {
		FK_id = fK_id;
	}

	
// 以下是中间辅助变量的get方法
	public int getNum() {
		return this.num;
	}
	public int getNum2() {
		return this.num2;
	}
	public String getIsFirst() {
		return this.isFirst;
	}
	public List<Hbsy> getAllList() {
		return this.allList;
	}
	public Pager getPager() {
		return pager;
	}

	public void setPager(Pager pager) {
		this.pager = pager;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}	
	public String getWord(){
		return this.word;
	}
	public void setWord(String word){
		this.word=word;
	}
	public String getKeyword(){
		return this.keyword;
	}
	public void setKeyword(String keyword){
		this.keyword=keyword;
	}
	public List<Hbsy> getTypeList() {
		return this.typeList;
	}
	public String[] getStr1(){
		return this.str1;
	}
	public String[] getNumRank(){
		return this.numRank;
	}
	public int[] getNumRankId(){
		return this.numRankId;
	}
	public String getDateString(){
		return this.dateString;
	}
// 以下是STRUTS的ACTION
	
	//首页的ACTION
	public String hbsy_index_look() {
		System.out.print("执行到Action层!\n");
		num = hbsyservice.getRows();
		int max =num;
		pager.setMaxRecords(max);
		paging();
		allList=hbsyservice.viewHbsyByList(pager.getOffset(),pager.getPageSize());	
		
		List<Hbsy> temp=hbsyservice.selectAllByCount();
		int k=max>4?4:max;
		numRank=new String[k];
		numRankId=new int[k];
		for(int i=0;i<k;i++){
			numRank[i]=temp.get(i).getE_name();
			numRankId[i]=temp.get(i).getId();
		}
		num2=pager.getCurrentPage();
		isFirst=""+num2;
		System.out.print("isFirst="+isFirst);
		return "hbsylook";
	}

	public String hbsy_index_add() {
		System.out.print("执行到Action层!\n");
		TreeSet<String> tr = new TreeSet<String>();		
		System.out.println("共有列表为"+hbsyservice.typeList().size());
		for (int i = 0; i < hbsyservice.typeList().size(); i++) {
			if(hbsyservice.selectAll().get(i).getE_type()==null){
				tr.add("默认分类");
			}
			else{
				tr.add(hbsyservice.selectAll().get(i).getE_type());
				}
		}
		str1 = new String[tr.size()+1];
		str1[0]="默认分类";
		 for(int i=1;i<str1.length;i++){
			str1[i]=tr.pollFirst();
		 }
		System.out.print("遍历完毕!\n");
		return "hbsyadd";
	}

	public String hbsy_index_manage() {
		System.out.print("执行到Action层!\n");
		
		int max =hbsyservice.getRows();
		pager.setMaxRecords(max);
		paging();
		allList=hbsyservice.viewHbsyByList(pager.getOffset(),pager.getPageSize());
		
		return "hbsymanage";
	}

	
//Crud的Action方法
	public String hbsy_add() throws Exception {
		System.out.print("执行到Action层!\n");
		Date date = new Date();
		e_addtime = new Date(date.getTime());
		h.setE_name(e_name);
		StringBuffer temp_a=new StringBuffer();
		for(int i=0;i<e_abstract.length();i++){
			if(e_abstract.charAt(i)=='\n'){
				temp_a.append("<br/>");
			}
			temp_a.append(e_abstract.charAt(i));
		}
		e_abstract=temp_a.toString();
		h.setE_abstract(e_abstract);
		StringBuffer temp_d=new StringBuffer();
		for(int i=0;i<e_detail.length();i++){
			if(e_detail.charAt(i)=='\n'){
				temp_d.append("<br/>");
			}
			temp_d.append(e_detail.charAt(i));
		}
		e_detail=temp_d.toString();
		h.setE_detail(e_detail);
		h.setE_addtime(e_addtime);
		h.setE_type(e_type);
		h.setE_personId(00000000);
		h.setE_count(0);
		hbsyservice.add(h);
		System.out.println("刚才上传的环保术语的ID为:"+h.getId());		
		if(file==null){
			System.out.print("图片为空!");
			System.out.print(h.getE_count());
			Hbsy h2=hbsyservice.findFromId(h.getId());
			h2.setE_count(h.getE_count()+1);
			hbsyservice.update(h2);
			return "hbsylook_no_pic";
		}
		hbsy_pic_add(h.getId());
		System.out.print(h.getE_count());
		Hbsy h2=hbsyservice.findFromId(h.getId());
		h2.setE_count(h.getE_count()+1);
		hbsyservice.update(h2);
		
		List<Hbsy> temp=hbsyservice.selectAllByCount();
		int k0=hbsyservice.getRows();
		int k=k0>4?4:k0;
		numRank=new String[k];
		numRankId=new int[k];
		for(int i=0;i<k;i++){
			numRank[i]=temp.get(i).getE_name();
			numRankId[i]=temp.get(i).getId();
		}
		
		return "hbsylook";
	}

	public String hbsy_look() {
		System.out.print("执行到Action层!\n");
		h = hbsyservice.findFromId(id);
		java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd");
		System.out.print("刚从数据库取出的时间为"+h.getE_addtime());
		dateString=""+df.format(h.getE_addtime().getTime());		
		p=pictureservice.findFromId(id);
		System.out.print(h.getE_count());
		Hbsy h2=hbsyservice.findFromId(id);
		h2.setE_count(h.getE_count()+1);
		hbsyservice.update(h2);
		List<Hbsy> temp=hbsyservice.selectAllByCount();
		int k0=hbsyservice.getRows();
		int k=k0>4?4:k0;
		numRank=new String[k];
		numRankId=new int[k];
		for(int i=0;i<k;i++){
			numRank[i]=temp.get(i).getE_name();
			numRankId[i]=temp.get(i).getId();
		}
		s_ip=getIpAddr(ServletActionContext.getRequest());
		String judge=hbsy_pic_look();
		if(judge=="no_pic"){
			return "hbsylook_no_pic";
		}
		return "hbsylook";
	}

	public String hbsy_delete() {
		System.out.print("执行到Action层!\n");
		h = hbsyservice.findFromId(id);
		hbsyservice.delete(h);
		p=new Picture();
		p=pictureservice.findeIdPic(id);
		pictureservice.delete(p);
		
		int max =hbsyservice.getRows();
		pager.setMaxRecords(max);
		paging();
		allList=hbsyservice.viewHbsyByList(pager.getOffset(),pager.getPageSize());
		
		return "hbsydelete";
	}

	public String hbsy_update() {
		System.out.print("执行到Action层!\n");
		h = hbsyservice.findFromId(id);
		return "hbsyupdate";
	}

	public String hbsy_update_do() throws Exception {
		System.out.print("执行到Action层!\n");
		System.out.println("ID=" + id);
		h = hbsyservice.findFromId(id);
		System.out.println("e_name=" + e_name);
		h.setE_name(e_name);
		h.setE_abstract(e_abstract);
		h.setE_detail(e_detail);
		h.setE_type(e_type);
		hbsyservice.update(h);
		String judge=hbsy_pic_look();
		if(file==null){
			System.out.print("无图片");
		}
		else{
			if(judge=="no_pic"){
				hbsy_pic_add(id);
			}
			else{
				p=pictureservice.findeIdPic(id);
				FileInputStream fin;
				fin = new FileInputStream(file);
				p_picture = new byte[(int)fin.available()];
				fin.read(p_picture);
				fin.close();
				p.setFk_eId(id);
				p.setFk_aId(0);
				p.setFk_mId(0);
				p.setFk_pid(0);
				p.setP_describe(p_describe);
				p.setP_extension(p_extension);
				p.setP_picture(p_picture);
				p.setP_place(p_place);
				p.setP_title(p_title);
				p.setP_type(p_type);
				p.setPerson(Person);
				pictureservice.update(p);
			}
		}
		int max =hbsyservice.getRows();
		pager.setMaxRecords(max);
		paging();
		allList=hbsyservice.viewHbsyByList(pager.getOffset(),pager.getPageSize());
		
		List<Hbsy> temp=hbsyservice.selectAllByCount();
		int k0=hbsyservice.getRows();
		int k=k0>4?4:k0;
		numRank=new String[k];
		numRankId=new int[k];
		for(int i=0;i<k;i++){
			numRank[i]=temp.get(i).getE_name();
			numRankId[i]=temp.get(i).getId();
		}
		
		return "hbsyupdate";
	}

	public String hbsy_pic_add(int hbsy_id) throws Exception{
		p=new Picture();
		System.out.print("执行到图片插入函数");
		FileInputStream fin;
		fin = new FileInputStream(file);
		p_picture = new byte[(int)fin.available()];
		fin.read(p_picture);
		fin.close();
		p.setFk_eId(hbsy_id);
		p.setFk_aId(0);
		p.setFk_mId(0);
		p.setFk_pid(0);
		p.setP_title(p_title);
		p.setP_describe(p_describe);
		p.setP_place(p_place);
		p.setP_type(p_type);
		p.setP_picture(p_picture);
		p.setP_extension(p_extension);
		p.setPerson(Person);
		pictureservice.add(p);
		return "add pic success!"; 
	}
	
	public String hbsy_pic_look(){
		System.out.println("需要查找的ID="+id);
		p=pictureservice.findeIdPic(id);
		if(p==null){
			return "no_pic";
		}
		byte[] p_picture = p.getP_picture();
		if(p_picture!=null){
			System.out.print("图片不为空!");
		}
		ActionContext.getContext().getSession().put("p_picture", p_picture);
			return "p_picture";
	}
	
	//环保术语检索
	public String hbsy_search(){
		if(word.equals("e_name")){
			System.out.println("即将搜索到的关键字为"+keyword);
			num = hbsyservice.searchName(keyword).size();
			int max =num;
			pager.setMaxRecords(max);
			paging();
			allList=hbsyservice.searchNameListByPage(pager.getOffset(),pager.getPageSize(),keyword);			
		}
		else if(word.equals("e_type")){
			System.out.println("即将搜索到的关键字为"+keyword);
			num = hbsyservice.searchType(keyword).size();
			int max =num;
			pager.setMaxRecords(max);
			paging();
			allList=hbsyservice.searchTypeListByPage(pager.getOffset(),pager.getPageSize(),keyword);			
		}
		else{
			System.out.println("即将搜索到的关键字为"+keyword);
			num = hbsyservice.searchDetailList(keyword).size();
			int max =num;
			pager.setMaxRecords(max);
			paging();
			allList=hbsyservice.searchDetailListByPage(pager.getOffset(),pager.getPageSize(),keyword);			
		}
		return "search_success";
	}
	
	//术语统计
	public void hbsy_sta(){
		System.out.print("进入统计数据层");
		sta.setFK_id(FK_id);
		System.out.print("要插入的数据FK_ID="+FK_id);
		Date c = new Date();
		c.setTime(Long.valueOf(s_enterTime));
		Date e = new Date();
		e.setTime(Long.valueOf(s_enterTime));
		sta.setS_closeTime(c);
		sta.setS_enterTime(e);
		sta.setS_ip(s_ip);
		sta.setS_totalTime(Long.parseLong(s_totalTime));
		sta.setS_type(s_type);
		statisticsservice.saveSta(sta);
	}
	
	//分页
	public void paging(){
		pager.setPageSize(9);
		pager=hbsyservice.pageInitial(pager, method);
	}
	//查看IP
	public String getIpAddr(HttpServletRequest request){
		String ip=request.getHeader("x-forwarded-for");
		if(ip==null||ip.length()==0||"unknown".equalsIgnoreCase(ip)){
			ip=request.getHeader("Proxy-Client-IP");
		}
		if(ip==null||ip.length()==0||"unknown".equalsIgnoreCase(ip)){
			ip=request.getHeader("WL-Proxy-Client-IP");
		}
		if(ip==null||ip.length()==0||"unknown".equalsIgnoreCase(ip)){
			ip=request.getRemoteAddr();
		}
		return ip;
	}
}
