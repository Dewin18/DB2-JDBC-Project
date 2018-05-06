package services;

import materials.EstateAgent;

public interface RegisterServiceIF {
    
    public boolean registerEstateAgent(EstateAgent agent);
    
    public boolean estateAgentExist(String loginName);
    
    public boolean deleteEstateAgent(String loginName);
    
    public boolean updateColumnInEstateAgent(String column, String loginName, String newAttribute);
}
