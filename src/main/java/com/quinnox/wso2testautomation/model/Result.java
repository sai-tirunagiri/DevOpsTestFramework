package com.quinnox.wso2testautomation.model;
public class Result
{
    private String NAME;

    private String AGE;

    private String GENDER;

    private String xmlns;

    public String getNAME ()
    {
        return NAME;
    }

    public void setNAME (String NAME)
    {
        this.NAME = NAME;
    }

    public String getAGE ()
    {
        return AGE;
    }

    public void setAGE (String AGE)
    {
        this.AGE = AGE;
    }

    public String getGENDER ()
    {
        return GENDER;
    }

    public void setGENDER (String GENDER)
    {
        this.GENDER = GENDER;
    }

    public String getXmlns ()
    {
        return xmlns;
    }

    public void setXmlns (String xmlns)
    {
        this.xmlns = xmlns;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [NAME = "+NAME+", AGE = "+AGE+", GENDER = "+GENDER+", xmlns = "+xmlns+"]";
    }
}