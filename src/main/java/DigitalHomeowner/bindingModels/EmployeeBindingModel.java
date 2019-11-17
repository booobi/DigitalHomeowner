package DigitalHomeowner.bindingModels;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class EmployeeBindingModel {

    private String fName;
    private String lName;
    private Integer age;
    private String gender;
    private List<String> buildingIdsToManage;

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<String> getBuildingIdsToManage() {
        return buildingIdsToManage;
    }

    public void setBuildingIdsToManage(List<String> buildingIdsToManage) {
        this.buildingIdsToManage = buildingIdsToManage;
    }
}
