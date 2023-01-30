package Model;

public enum RolesColumn {
    ID ("id"),
    NAME ("name"),
    DESCRIPTION ("description");

    private String value ;
    RolesColumn (String value )
    {
        this.value=value;
    }

    public String getValue()
    {
        return this.value;
    }
}
