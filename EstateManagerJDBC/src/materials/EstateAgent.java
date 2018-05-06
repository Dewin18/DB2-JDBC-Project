package materials;

public class EstateAgent {
    private String _name;
    private String _address;
    private String _login;
    private String _password;
    
    public EstateAgent(String name, String address, String login, String password) {
	_name = name;
	_address = address;
	_login = login;
	_password = password;
    }
    
    public String getName() {
	return _name;
    }
    
    public String getAddress() {
        return _address;
    }

    public String getLogin() {
        return _login;
    }

    public String getPassword() {
        return _password;
    }
}
