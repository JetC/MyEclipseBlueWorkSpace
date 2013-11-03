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

public class HdjyAction{
	//环保术语字段
	private int id;
	private String a_title;
	private String a_abstract;
	private String a_detail;
	private Date a_time;
	private Date a_addtime;
	private int a_personId;	
	private int a_count;
	private String a_type;
	protected Hdjy h;
	protected HdjyService hdjyservice;
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
	int Fk_aId;
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
	List<Hdjy> allList;
	Pager pager=new Pager();
	String method="";
	String word="";//搜索类型
	String keyword="";//搜索关键字
	String dateString="";
	List<Hdjy> typeList;
	String[] str1;
	String[] numRank;
	int[] numRankId;
// 以下是类对象的set和get
	public Hdjy getH() {
		return h;
	}
	public void setH(Hdjy h) {
		this.h = h;
	}
	public HdjyService getHdjyservice() {
		return hdjyservice;
	}
	public void setHdjyservice(HdjyService hdjyservice) {
		this.hdjyservice = hdjyservice;
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

	// 以下是活动纪要的字段
	public void setId(String id) {
		this.id = Integer.parseInt(id);
	}
	public int getId() {
		return this.id;
	}
	public void setA_title(String a_title){
		this.a_title=a_title;
	}
	public String getA_title(){
		return this.a_title;
	}
	
	public void setA_abstract(String a_abstract){
		this.a_abstract=a_abstract;
	}
	public String getA_abstract(){
		return this.a_abstract;
	}
	
	public void setA_detail(String a_detail){
		this.a_detail=a_detail;
	}
	public String getA_detail(){
		return this.a_detail;
	}
	public void setA_time(Date a_time){
		this.a_time=a_time;
	}
	public Date getA_time(){		
		return this.a_time;
	}
	public void setA_addtime(Date a_addtime){
		this.a_addtime=a_addtime;
	}
	public Date getA_addtime(){		
		return this.a_addtime;
	}
	
	public void setA_personId(int a_personId){
		this.a_personId=a_personId;
	}
	public int getA_personId(){
		return this.a_personId;
	}
	
	public void setA_count(int a_count){
		this.a_count=a_count;
	}
	public int getA_count(){
		return this.a_count;
	}
	
	public void setA_type(String a_type){
		this.a_type=a_type;
	}
	public String getA_type(){
		return this.a_type;
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
	public void setFk_aId(int Fk_aId) {
		this.Fk_aId = Fk_aId;
	}
	public int getFk_aId() {
		return this.Fk_aId;
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
	public List<Hdjy> getAllList() {
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
	public List<Hdjy> getTypeList() {
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
	public String hdjy_index_look() {
		System.out.print("执行到Action层!\n");
		num = hdjyservice.getRows();
		int max =num;
		pager.setMaxRecords(max);
		paging();
		allList=hdjyservice.viewHdjyByList(pager.getOffset(),pager.getPageSize());	
		
		List<Hdjy> temp=hdjyservice.selectAllByCount();
		int k=max>4?4:max;
		numRank=new String[k];
		numRankId=new int[k];
		for(int i=0;i<k;i++){
			numRank[i]=temp.get(i).getA_title();
			numRankId[i]=temp.get(i).getId();
		}
		num2=pager.getCurrentPage();
		isFirst=""+num2;
		System.out.print("isFirst="+isFirst);
		return "hdjylook";
	}

	public String hdjy_index_add() {
		System.out.print("执行到Action层!\n");
		TreeSet<String> tr = new TreeSet<String>();		
		System.out.println("共有列表为"+hdjyservice.typeList().size());
		for (int i = 0; i < hdjyservice.typeList().size(); i++) {
			if(hdjyservice.selectAll().get(i).getA_type()==null){
				tr.add("默认分类");
			}
			else{
				tr.add(hdjyservice.selectAll().get(i).getA_type());
				}
		}
		str1 = new String[tr.size()+1];
		str1[0]="默认分类";
		 for(int i=1;i<str1.length;i++){
			str1[i]=tr.pollFirst();
		 }
		System.out.print("遍历完毕!\n");
		return "hdjyadd";
	}

	public String hdjy_index_manage() {
		System.out.print("执行到Action层!\n");
		
		int max =hdjyservice.getRows();
		pager.setMaxRecords(max);
		paging();
		allList=hdjyservice.viewHdjyByList(pager.getOffset(),pager.getPageSize());
		
		return "hdjymanage";
	}

	
//Crud的Action方法
	public String hdjy_add() throws Exception {
		System.out.print("执行到Action层!\n");
		Date date = new Date();
		a_addtime = new Date(date.getTime());
		a_time=new Date(date.getTime());//待修改
		h.setA_title(a_title);
		StringBuffer temp_a=new StringBuffer();
		for(int i=0;i<a_abstract.length();i++){
			if(a_abstract.charAt(i)=='\n'){
				temp_a.append("<br/>");
			}
			temp_a.append(a_abstract.charAt(i));
		}
		a_abstract=temp_a.toString();
		h.setA_abstract(a_abstract);
		StringBuffer temp_d=new StringBuffer();
		for(int i=0;i<a_detail.length();i++){
			if(a_detail.charAt(i)=='\n'){
				temp_d.append("<br/>");
			}
			temp_d.append(a_detail.charAt(i));
		}
		a_detail=temp_d.toString();
		h.setA_detail(a_detail);
		h.setA_time(a_time);
		h.setA_addtime(a_addtime);
		h.setA_type(a_type);
		h.setA_personId(00000000);
		h.setA_count(0);
		hdjyservice.add(h);
		System.out.println("刚才上传的环保术语的ID为:"+h.getId());		
		if(file==null){
			System.out.print("图片为空!");
			System.out.print(h.getA_count());
			Hdjy h2=hdjyservice.findFromId(h.getId());
			h2.setA_count(h.getA_count()+1);
			hdjyservice.update(h2);
			return "hdjylook_no_pic";
		}
		hdjy_pic_add(h.getId());
		System.out.print(h.getA_count());
		Hdjy h2=hdjyservice.findFromId(h.getId());
		h2.setA_count(h.getA_count()+1);
		hdjyservice.update(h2);
		
		List<Hdjy> temp=hdjyservice.selectAllByCount();
		int k0=hdjyservice.getRows();
		int k=k0>4?4:k0;
		numRank=new String[k];
		numRankId=new int[k];
		for(int i=0;i<k;i++){
			numRank[i]=temp.get(i).getA_title();
			numRankId[i]=temp.get(i).getId();
		}
		
		return "hdjylook";
	}

	public String hdjy_look() {
		System.out.print("执行到Action层!\n");
		h = hdjyservice.findFromId(id);
		java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd");
		System.out.print("刚从数据库取出的时间为"+h.getA_addtime());
		dateString=""+df.format(h.getA_addtime().getTime());		
		p=pictureservice.findFromId(id);
		System.out.print(h.getA_count());
		Hdjy h2=hdjyservice.findFromId(id);
		h2.setA_count(h.getA_count()+1);
		hdjyservice.update(h2);
		List<Hdjy> temp=hdjyservice.selectAllByCount();
		int k0=hdjyservice.getRows();
		int k=k0>4?4:k0;
		numRank=new String[k];
		numRankId=new int[k];
		for(int i=0;i<k;i++){
			numRank[i]=temp.get(i).getA_title();
			numRankId[i]=temp.get(i).getId();
		}
		s_ip=getIpAddr(ServletActionContext.getRequest());
		String judge=hdjy_pic_look();
		if(judge=="no_pic"){
			return "hdjylook_no_pic";
		}
		return "hdjylook";
	}

	public String hdjy_delete() {
		System.out.print("执行到Action层!\n");
		h = hdjyservice.findFromId(id);
		hdjyservice.delete(h);
		p=new Picture();
		p=pictureservice.findaIdPic(id);
		pictureservice.delete(p);
		
		int max =hdjyservice.getRows();
		pager.setMaxRecords(max);
		paging();
		allList=hdjyservice.viewHdjyByList(pager.getOffset(),pager.getPageSize());
		
		return "hdjydelete";
	}

	public String hdjy_update() {
		System.out.print("执行到Action层!\n");
		h = hdjyservice.findFromId(id);
		return "hdjyupdate";
	}

	public String hdjy_update_do() throws Exception {
		System.out.print("执行到Action层!\n");
		System.out.println("ID=" + id);
		h = hdjyservice.findFromId(id);
		System.out.println("a_title=" + a_title);
		h.setA_title(a_title);
		h.setA_abstract(a_abstract);
		h.setA_detail(a_detail);
		h.setA_type(a_type);
		hdjyservice.update(h);
		
		String judge=hdjy_pic_look();
		if(file==null){
			System.out.print("无图片");
		}
		else{
			if(judge=="no_pic"){
				hdjy_pic_add(id);
			}
			else{
				p=pictureservice.findaIdPic(id);
				FileInputStream fin;
				fin = new FileInputStream(file);
				p_picture = new byte[(int)fin.available()];
				fin.read(p_picture);
				fin.close();
				p.setFk_aId(id);
				p.setFk_mId(0);
				p.setFk_eId(0);
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
		
		int max =hdjyservice.getRows();
		pager.setMaxRecords(max);
		paging();
		allList=hdjyservice.viewHdjyByList(pager.getOffset(),pager.getPageSize());
		
		List<Hdjy> temp=hdjyservice.selectAllByCount();
		int k0=hdjyservice.getRows();
		int k=k0>4?4:k0;
		numRank=new String[k];
		numRankId=new int[k];
		for(int i=0;i<k;i++){
			numRank[i]=temp.get(i).getA_title();
			numRankId[i]=temp.get(i).getId();
		}
		
		return "hdjyupdate";
	}

	public String hdjy_pic_add(int hdjy_id) throws Exception{
		p=new Picture();
		System.out.print("执行到图片插入函数");
		FileInputStream fin;
		fin = new FileInputStream(file);
		p_picture = new byte[(int)fin.available()];
		fin.read(p_picture);
		fin.close();
		p.setFk_aId(hdjy_id);
		p.setFk_eId(0);
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
	
	public String hdjy_pic_look(){
		System.out.println("需要查找的ID="+id);
		p=pictureservice.findaIdPic(id);
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
	public String hdjy_search(){
		if(word.equals("a_title")){
			System.out.println("即将搜索到的关键字为"+keyword);
			num = hdjyservice.searchName(keyword).size();
			int max =num;
			pager.setMaxRecords(max);
			paging();
			allList=hdjyservice.searchNameListByPage(pager.getOffset(),pager.getPageSize(),keyword);			
		}
		else if(word.equals("a_type")){
			System.out.println("即将搜索到的关键字为"+keyword);
			num = hdjyservice.searchType(keyword).size();
			int max =num;
			pager.setMaxRecords(max);
			paging();
			allList=hdjyservice.searchTypeListByPage(pager.getOffset(),pager.getPageSize(),keyword);			
		}
		else{
			System.out.println("即将搜索到的关键字为"+keyword);
			num = hdjyservice.searchDetailList(keyword).size();
			int max =num;
			pager.setMaxRecords(max);
			paging();
			allList=hdjyservice.searchDetailListByPage(pager.getOffset(),pager.getPageSize(),keyword);			
		}
		return "search_success";
	}
	
	//活动纪要统计
	public void hdjy_sta(){
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
		pager=hdjyservice.pageInitial(pager, method);
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
