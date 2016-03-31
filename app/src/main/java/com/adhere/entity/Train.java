package com.adhere.entity;

import java.util.List;

/**
 * 作者：高俊 on 2016/2/29 0029 18:44
 */
public class Train {



    /**
     * types : {"普通班":17,"重点班":5}
     * income : 0
     * totalNum : 1399
     * sponsorNum : 121
     * trainNum : 22
     * teacherNum : 84
     * assistant : 徐洪颖、谢蟾、张亚玭、黄晟、傅晓婷、姚张毅、杨贵东、张茂东、火彩华、陆勇、程琳、邱雅婷、史静、廖晓静、叶静伟
     * studentNum : 1194
     * rows : [{"CourseURL":"","address":"学院内","assess":null,"assistant":"徐洪颖、谢蟾","campus":"上海校区","classTeacher":"蔡睿峰","classroom":"1301","dept":"培训实施运营中心","dineAddress":"园区食堂","endDate":"2015-12-19","id":203,"income":0,"meetingroom":"","name":"2015中国电信法律工作座谈会","property":"计划外培训班","registerDate":null,"remark":"","sponsorNum":6,"startDate":"2015-12-18","studentNum":68,"studentURL":"","teacherNum":2,"totalNum":76,"types":"普通班"},{"CourseURL":"","address":"学院内","assess":null,"assistant":"张亚玭、黄晟","campus":"上海校区","classTeacher":"张祺","classroom":"1305","dept":"培训实施运营中心","dineAddress":"园区食堂","endDate":"2015-12-18","id":202,"income":0,"meetingroom":"","name":"国际公司培训班","property":"计划内培训班","registerDate":null,"remark":"","sponsorNum":15,"startDate":"2015-12-15","studentNum":80,"studentURL":"","teacherNum":1,"totalNum":96,"types":"重点班"},{"CourseURL":null,"address":"学院内","assess":null,"assistant":"傅晓婷","campus":"上海校区","classTeacher":"李静伟","classroom":"1304","dept":"培训实施运营中心","dineAddress":"园区食堂","endDate":"2015-12-17","id":201,"income":0,"meetingroom":null,"name":"支付公司内训师师资班","property":"计划内培训班","registerDate":null,"remark":null,"sponsorNum":4,"startDate":"2015-12-15","studentNum":35,"studentURL":null,"teacherNum":5,"totalNum":44,"types":"普通班"},{"CourseURL":null,"address":"学院内","assess":null,"assistant":"姚张毅","campus":"上海校区","classTeacher":"徐利民","classroom":null,"dept":"市场与销售人才教研中心","dineAddress":"园区食堂","endDate":"2015-12-12","id":200,"income":0,"meetingroom":null,"name":"《小CEO绩效促进》课程认证研讨班","property":"计划内培训班","registerDate":null,"remark":null,"sponsorNum":0,"startDate":"2015-12-10","studentNum":18,"studentURL":null,"teacherNum":4,"totalNum":22,"types":"普通班"},{"CourseURL":null,"address":"学院内","assess":null,"assistant":"傅晓婷、杨贵东","campus":"上海校区","classTeacher":"张祺","classroom":"1101","dept":"培训实施运营中心","dineAddress":"园区食堂","endDate":"2015-12-11","id":199,"income":0,"meetingroom":null,"name":"全国人力条线培训专题研讨会","property":"计划内培训班","registerDate":null,"remark":null,"sponsorNum":10,"startDate":"2015-12-09","studentNum":110,"studentURL":null,"teacherNum":5,"totalNum":125,"types":"普通班"},{"CourseURL":null,"address":"学院内","assess":null,"assistant":"张茂东、谢蟾、徐洪颖、张亚玭","campus":"上海校区","classTeacher":"李静伟","classroom":"1301","dept":"培训实施运营中心","dineAddress":"B17餐厅二楼","endDate":"2015-12-12","id":198,"income":0,"meetingroom":null,"name":"省级公司纪检组长、主任培训班","property":"计划内培训班","registerDate":null,"remark":null,"sponsorNum":12,"startDate":"2015-12-08","studentNum":77,"studentURL":null,"teacherNum":6,"totalNum":95,"types":"重点班"},{"CourseURL":null,"address":"学院内","assess":null,"assistant":"火彩华、陆勇","campus":"上海校区","classTeacher":"陈志伟","classroom":"1305","dept":"创新与转型人才教研中心","dineAddress":"园区食堂","endDate":"2015-12-08","id":197,"income":0,"meetingroom":null,"name":"网运部内训师训练营","property":"计划内培训班","registerDate":null,"remark":null,"sponsorNum":2,"startDate":"2015-12-07","studentNum":60,"studentURL":null,"teacherNum":3,"totalNum":65,"types":"普通班"},{"CourseURL":"","address":"学院内","assess":null,"assistant":"徐洪颖","campus":"上海校区","classTeacher":"李立丹","classroom":"1203","dept":"领导力教研中心","dineAddress":"园区餐厅二楼","endDate":"2015-12-08","id":196,"income":0,"meetingroom":"","name":"领越领导力认证讲师培训班","property":"计划内培训班","registerDate":null,"remark":"","sponsorNum":2,"startDate":"2015-12-05","studentNum":12,"studentURL":"","teacherNum":1,"totalNum":15,"types":"重点班"},{"CourseURL":null,"address":"学院内","assess":null,"assistant":"火彩华","campus":"上海校区","classTeacher":null,"classroom":"1305","dept":"教务部","dineAddress":"不吃饭","endDate":"2015-12-05","id":195,"income":0,"meetingroom":null,"name":" 学院沙龙讲座","property":"内部市场化班","registerDate":null,"remark":null,"sponsorNum":2,"startDate":"2015-12-05","studentNum":50,"studentURL":null,"teacherNum":0,"totalNum":52,"types":"普通班"},{"CourseURL":"","address":"学院内","assess":null,"assistant":"张亚玭、傅晓婷","campus":"上海校区","classTeacher":"陈湘曦","classroom":"1301","dept":"培训实施运营中心","dineAddress":"B17","endDate":"2015-12-04","id":194,"income":0,"meetingroom":"","name":"2015年国家广电总局新闻总署电子出版专题培训班","property":"外部市场化班","registerDate":null,"remark":"","sponsorNum":10,"startDate":"2015-12-02","studentNum":100,"studentURL":"","teacherNum":7,"totalNum":117,"types":"重点班"},{"CourseURL":"","address":"学院内","assess":null,"assistant":"陆勇","campus":"上海校区","classTeacher":"申笑阅","classroom":"1302","dept":"培训实施运营中心","dineAddress":"园区餐厅二楼","endDate":"2015-12-02","id":193,"income":0,"meetingroom":"","name":"新技术及业务培训班","property":"计划内培训班","registerDate":null,"remark":"","sponsorNum":3,"startDate":"2015-12-01","studentNum":66,"studentURL":"","teacherNum":9,"totalNum":78,"types":"普通班"},{"CourseURL":"","address":"学院内","assess":null,"assistant":"谢蟾、徐洪颖","campus":"上海校区","classTeacher":"李娜","classroom":"1201、1203","dept":"领导力教研中心","dineAddress":"园区餐厅二楼","endDate":"2015-12-04","id":192,"income":0,"meetingroom":"","name":"2015年中国电信创业家训练营A4班单元c","property":"计划内培训班","registerDate":null,"remark":"","sponsorNum":12,"startDate":"2015-12-01","studentNum":30,"studentURL":"","teacherNum":8,"totalNum":50,"types":"重点班"},{"CourseURL":"","address":"学院内","assess":null,"assistant":"火彩华","campus":"上海校区","classTeacher":"","classroom":"1305","dept":"教务部","dineAddress":"B17","endDate":"2015-11-30","id":191,"income":0,"meetingroom":"","name":"2015年度项目经验集中分享切磋安排","property":"计划内培训班","registerDate":null,"remark":"","sponsorNum":0,"startDate":"2015-11-30","studentNum":43,"studentURL":"","teacherNum":0,"totalNum":43,"types":"普通班"},{"CourseURL":"","address":"学院内","assess":null,"assistant":"火彩华、陆勇","campus":"上海校区","classTeacher":"蔡睿峰","classroom":"1101","dept":"培训实施运营中心","dineAddress":"17B","endDate":"2015-11-27","id":190,"income":0,"meetingroom":"1102、1303","name":"多媒体智能客服运营管理培训班","property":"计划内培训班","registerDate":null,"remark":"","sponsorNum":5,"startDate":"2015-11-26","studentNum":35,"studentURL":"","teacherNum":0,"totalNum":40,"types":"普通班"},{"CourseURL":"","address":"学院内","assess":null,"assistant":"程琳、黄晟","campus":"上海校区","classTeacher":"徐利民","classroom":"1301","dept":"市场与销售人才教研中心","dineAddress":"园区餐厅二楼","endDate":"2015-11-27","id":189,"income":0,"meetingroom":null,"name":"O2O渠道协同培训班（第二期）","property":"计划内培训班","registerDate":null,"remark":"","sponsorNum":5,"startDate":"2015-11-26","studentNum":100,"studentURL":"","teacherNum":5,"totalNum":110,"types":"普通班"},{"CourseURL":"","address":"学院内","assess":null,"assistant":"邱雅婷","campus":"上海校区","classTeacher":"张祺","classroom":"1302","dept":"培训实施运营中心","dineAddress":"园区餐厅二楼","endDate":"2015-11-26","id":188,"income":0,"meetingroom":"","name":"中国电信山西分公司2015年度干部培训班","property":"计划外培训班","registerDate":null,"remark":"","sponsorNum":0,"startDate":"2015-11-26","studentNum":25,"studentURL":"","teacherNum":1,"totalNum":26,"types":"普通班"},{"CourseURL":null,"address":"学院内","assess":null,"assistant":"姚张毅、史静","campus":"上海校区","classTeacher":"王益忠","classroom":"1305","dept":"创新与转型人才教研中心","dineAddress":"园区餐厅二楼","endDate":"2015-11-28","id":187,"income":0,"meetingroom":null,"name":"杭电项目中层管理者培训班（第2期）","property":"内部市场化班","registerDate":null,"remark":null,"sponsorNum":2,"startDate":"2015-11-26","studentNum":58,"studentURL":null,"teacherNum":4,"totalNum":64,"types":"普通班"},{"CourseURL":null,"address":"学院内","assess":null,"assistant":"徐洪颖、张茂东","campus":"上海校区","classTeacher":"张萍萍","classroom":"1201","dept":"培训实施运营中心","dineAddress":"17B","endDate":"2015-11-27","id":186,"income":0,"meetingroom":null,"name":"采购部主任培训班","property":"计划内培训班","registerDate":null,"remark":null,"sponsorNum":11,"startDate":"2015-11-25","studentNum":35,"studentURL":null,"teacherNum":3,"totalNum":49,"types":"普通班"},{"CourseURL":null,"address":"学院内","assess":null,"assistant":"廖晓静、徐洪颖","campus":"上海校区","classTeacher":"蔡睿峰","classroom":"1304","dept":"培训实施运营中心","dineAddress":"园区餐厅二楼","endDate":"2015-11-24","id":185,"income":0,"meetingroom":"1205、1206、1207","name":"电子金融与天翼规模发展地市公司培训班","property":"计划内培训班","registerDate":null,"remark":null,"sponsorNum":10,"startDate":"2015-11-23","studentNum":42,"studentURL":null,"teacherNum":5,"totalNum":57,"types":"普通班"},{"CourseURL":null,"address":"学院内","assess":null,"assistant":"谢蟾","campus":"上海校区","classTeacher":"徐勇","classroom":"1302","dept":"创新与转型人才教研中心","dineAddress":"园区餐厅二楼","endDate":"2015-11-25","id":184,"income":0,"meetingroom":null,"name":"创新业务单元HRD研修班","property":"计划内培训班","registerDate":null,"remark":null,"sponsorNum":2,"startDate":"2015-11-23","studentNum":40,"studentURL":null,"teacherNum":4,"totalNum":46,"types":"普通班"},{"CourseURL":null,"address":"学院内","assess":null,"assistant":"叶静伟、傅晓婷","campus":"上海校区","classTeacher":"李静伟","classroom":null,"dept":"培训实施运营中心","dineAddress":"园区餐厅二楼","endDate":"2015-11-27","id":183,"income":0,"meetingroom":null,"name":"10000号通用类客服课程师资班","property":"计划内培训班","registerDate":null,"remark":null,"sponsorNum":6,"startDate":"2015-11-23","studentNum":52,"studentURL":null,"teacherNum":7,"totalNum":65,"types":"普通班"},{"CourseURL":null,"address":"学院内","assess":null,"assistant":"姚张毅、史静","campus":"上海校区","classTeacher":"王益忠","classroom":"1305","dept":"创新与转型人才教研中心","dineAddress":"园区餐厅二楼","endDate":"2015-11-24","id":182,"income":0,"meetingroom":null,"name":"杭电项目中层管理者培训班（第1期）","property":"内部市场化班","registerDate":null,"remark":null,"sponsorNum":2,"startDate":"2015-11-22","studentNum":58,"studentURL":null,"teacherNum":4,"totalNum":64,"types":"普通班"}]
     */

    private int income;
    private int totalNum;
    private int sponsorNum;
    private int trainNum;
    private int teacherNum;
    private String assistant;
    private int studentNum;
    /**
     * CourseURL :
     * address : 学院内
     * assess : null
     * assistant : 徐洪颖、谢蟾
     * campus : 上海校区
     * classTeacher : 蔡睿峰
     * classroom : 1301
     * dept : 培训实施运营中心
     * dineAddress : 园区食堂
     * endDate : 2015-12-19
     * id : 203
     * income : 0
     * meetingroom :
     * name : 2015中国电信法律工作座谈会
     * property : 计划外培训班
     * registerDate : null
     * remark :
     * sponsorNum : 6
     * startDate : 2015-12-18
     * studentNum : 68
     * studentURL :
     * teacherNum : 2
     * totalNum : 76
     * types : 普通班
     */

    private List<RowsEntity> rows;


    public void setIncome(int income) {
        this.income = income;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }

    public void setSponsorNum(int sponsorNum) {
        this.sponsorNum = sponsorNum;
    }

    public void setTrainNum(int trainNum) {
        this.trainNum = trainNum;
    }

    public void setTeacherNum(int teacherNum) {
        this.teacherNum = teacherNum;
    }

    public void setAssistant(String assistant) {
        this.assistant = assistant;
    }

    public void setStudentNum(int studentNum) {
        this.studentNum = studentNum;
    }

    public void setRows(List<RowsEntity> rows) {
        this.rows = rows;
    }


    public int getIncome() {
        return income;
    }

    public int getTotalNum() {
        return totalNum;
    }

    public int getSponsorNum() {
        return sponsorNum;
    }

    public int getTrainNum() {
        return trainNum;
    }

    public int getTeacherNum() {
        return teacherNum;
    }

    public String getAssistant() {
        return assistant;
    }

    public int getStudentNum() {
        return studentNum;
    }

    public List<RowsEntity> getRows() {
        return rows;
    }


    public static class RowsEntity {
        private String CourseURL;
        private String address;
        private Object assess;
        private String assistant;
        private String campus;
        private String classTeacher;
        private String classroom;
        private String dept;
        private String dineAddress;
        private String endDate;
        private int id;
        private int income;
        private String meetingroom;
        private String name;
        private String property;
        private Object registerDate;
        private String remark;
        private int sponsorNum;
        private String startDate;
        private int studentNum;
        private String studentURL;
        private int teacherNum;
        private int totalNum;
        private String types;

        public void setCourseURL(String CourseURL) {
            this.CourseURL = CourseURL;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public void setAssess(Object assess) {
            this.assess = assess;
        }

        public void setAssistant(String assistant) {
            this.assistant = assistant;
        }

        public void setCampus(String campus) {
            this.campus = campus;
        }

        public void setClassTeacher(String classTeacher) {
            this.classTeacher = classTeacher;
        }

        public void setClassroom(String classroom) {
            this.classroom = classroom;
        }

        public void setDept(String dept) {
            this.dept = dept;
        }

        public void setDineAddress(String dineAddress) {
            this.dineAddress = dineAddress;
        }

        public void setEndDate(String endDate) {
            this.endDate = endDate;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setIncome(int income) {
            this.income = income;
        }

        public void setMeetingroom(String meetingroom) {
            this.meetingroom = meetingroom;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setProperty(String property) {
            this.property = property;
        }

        public void setRegisterDate(Object registerDate) {
            this.registerDate = registerDate;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public void setSponsorNum(int sponsorNum) {
            this.sponsorNum = sponsorNum;
        }

        public void setStartDate(String startDate) {
            this.startDate = startDate;
        }

        public void setStudentNum(int studentNum) {
            this.studentNum = studentNum;
        }

        public void setStudentURL(String studentURL) {
            this.studentURL = studentURL;
        }

        public void setTeacherNum(int teacherNum) {
            this.teacherNum = teacherNum;
        }

        public void setTotalNum(int totalNum) {
            this.totalNum = totalNum;
        }

        public void setTypes(String types) {
            this.types = types;
        }

        public String getCourseURL() {
            return CourseURL;
        }

        public String getAddress() {
            return address;
        }

        public Object getAssess() {
            return assess;
        }

        public String getAssistant() {
            return assistant;
        }

        public String getCampus() {
            return campus;
        }

        public String getClassTeacher() {
            return classTeacher;
        }

        public String getClassroom() {
            return classroom;
        }

        public String getDept() {
            return dept;
        }

        public String getDineAddress() {
            return dineAddress;
        }

        public String getEndDate() {
            return endDate;
        }

        public int getId() {
            return id;
        }

        public int getIncome() {
            return income;
        }

        public String getMeetingroom() {
            return meetingroom;
        }

        public String getName() {
            return name;
        }

        public String getProperty() {
            return property;
        }

        public Object getRegisterDate() {
            return registerDate;
        }

        public String getRemark() {
            return remark;
        }

        public int getSponsorNum() {
            return sponsorNum;
        }

        public String getStartDate() {
            return startDate;
        }

        public int getStudentNum() {
            return studentNum;
        }

        public String getStudentURL() {
            return studentURL;
        }

        public int getTeacherNum() {
            return teacherNum;
        }

        public int getTotalNum() {
            return totalNum;
        }

        public String getTypes() {
            return types;
        }
    }
}
