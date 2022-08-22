package org.wavemaker.manager;
import org.wavemaker.constants.PersistentType;
import org.wavemaker.implementation.UserManagementDBImpl;
import org.wavemaker.implementation.UserManagementInMemoryImpl;
import org.wavemaker.userinterface.UserOperations;
public class UserManagerFactory {
    public static UserOperations getUserManager(PersistentType.MEMORY_TYPE memoryType){
        if(memoryType==null ){
            return null;
        }
        switch (memoryType){
            case IN_MEMORY:
                return new UserManagementInMemoryImpl();
            case DB:
                return new UserManagementDBImpl();
            default:
                System.out.println("Illegal Memory Type");
                break;
        }
        return null;
    }
}
