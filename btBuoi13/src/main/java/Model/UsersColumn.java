package Model;

public enum UsersColumn {
    EMAIL ("email");

    private String value ;
    UsersColumn (String value )
    {
        this.value=value;
    }

    public String getValue()
    {
        return this.value;
    }
}
