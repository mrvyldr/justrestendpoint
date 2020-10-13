package com.veniture.plugins.tutorial.model;

public class MyPojo
{
    private String terms;

    private String success;

    private String privacy;

    private String source;

    private String timestamp;

    private Quotes quotes;

    public String getTerms ()
    {
        return terms;
    }

    public void setTerms (String terms)
    {
        this.terms = terms;
    }

    public String getSuccess ()
    {
        return success;
    }

    public void setSuccess (String success)
    {
        this.success = success;
    }

    public String getPrivacy ()
    {
        return privacy;
    }

    public void setPrivacy (String privacy)
    {
        this.privacy = privacy;
    }

    public String getSource ()
    {
        return source;
    }

    public void setSource (String source)
    {
        this.source = source;
    }

    public String getTimestamp ()
    {
        return timestamp;
    }

    public void setTimestamp (String timestamp)
    {
        this.timestamp = timestamp;
    }

    public Quotes getQuotes ()
    {
        return quotes;
    }

    public void setQuotes (Quotes quotes)
    {
        this.quotes = quotes;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [terms = "+terms+", success = "+success+", privacy = "+privacy+", source = "+source+", timestamp = "+timestamp+", quotes = "+quotes+"]";
    }
}

