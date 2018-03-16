package com.property.glory.propertyservice.bean;

import java.util.List;

/**
 * on 2018/3/6.
 */

public class User {
    public personalInfo personalInfo;
    public List<menuList> menuList;

    public personalInfo getPersonalinfo() {
        return personalInfo;
    }

    public void setPersonalinfo(personalInfo personalinfo) {
        this.personalInfo = personalinfo;
    }

    public List<menuList> getMenulist() {
        return menuList;
    }

    public void setMenulist(List<menuList> menulist) {
        this.menuList = menulist;
    }

  public   class personalInfo {
        private String workerId;
        private String petName;

        public String getWorkerId() {
            return workerId;
        }

        public void setWorkerId(String workerId) {
            this.workerId = workerId;
        }

        public String getPetName() {
            return petName;
        }

        public void setPetName(String petName) {
            this.petName = petName;
        }

        public String getPhoto() {
            return photo;
        }

        public void setPhoto(String photo) {
            this.photo = photo;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDepartmentName() {
            return departmentName;
        }

        public void setDepartmentName(String departmentName) {
            this.departmentName = departmentName;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }

        public String getOnline() {
            return online;
        }

        public void setOnline(String online) {
            this.online = online;
        }

        public String getBranchName() {
            return branchName;
        }

        public void setBranchName(String branchName) {
            this.branchName = branchName;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String photo;
        public String name;
        public String departmentName;
        public String position;
        public String online;
        public String branchName;
        public String phone;


    }

   public class menuList {
        private String moduleId;

        public String getModuleId() {
            return moduleId;
        }

        public void setModuleId(String moduleId) {
            this.moduleId = moduleId;
        }

        public String getModuleName() {
            return moduleName;
        }

        public void setModuleName(String moduleName) {
            this.moduleName = moduleName;
        }

        public String getUndealNo1() {
            return undealNo1;
        }

        public void setUndealNo1(String undealNo1) {
            this.undealNo1 = undealNo1;
        }

        public String getUndealNo2() {
            return undealNo2;
        }

        public void setUndealNo2(String undealNo2) {
            this.undealNo2 = undealNo2;
        }

        public String getAuthority() {
            return authority;
        }

        public void setAuthority(String authority) {
            this.authority = authority;
        }

        private String moduleName;
        private String undealNo1;
        private String undealNo2;
        private String authority;

    }
}
