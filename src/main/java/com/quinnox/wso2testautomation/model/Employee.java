package com.quinnox.wso2testautomation.model;
public class Employee
{
    private String EMP_NAME;

    private String EMP_AGE;

    private String EMPID;

    private String EMP_GENDER;

    public String getEMP_NAME ()
    {
        return EMP_NAME;
    }

    public void setEMP_NAME (String EMP_NAME)
    {
        this.EMP_NAME = EMP_NAME;
    }

    public String getEMP_AGE ()
    {
        return EMP_AGE;
    }

    public void setEMP_AGE (String EMP_AGE)
    {
        this.EMP_AGE = EMP_AGE;
    }

    public String getEMPID ()
    {
        return EMPID;
    }

    public void setEMPID (String EMPID)
    {
        this.EMPID = EMPID;
    }

    public String getEMP_GENDER ()
    {
        return EMP_GENDER;
    }

    public void setEMP_GENDER (String EMP_GENDER)
    {
        this.EMP_GENDER = EMP_GENDER;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [EMP_NAME = "+EMP_NAME+", EMP_AGE = "+EMP_AGE+", EMPID = "+EMPID+", EMP_GENDER = "+EMP_GENDER+"]";
    }
}
