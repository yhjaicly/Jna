import com.defaultValue.DefaultValue;
import com.jna.WhellDll;
import com.structures.DIJOYSTATE2ENGINES;
import com.structures.LogiControllerPropertiesData;
import com.sun.jna.platform.win32.WinDef;

public class whell {
    public static void main(String[] args) {
         int result = WhellDll.whellDll.LogiGetShifterMode(0);
        System.out.println(result);
        System.out.println(WhellDll.whellDll.LogiGetState(1));
        System.out.println(WhellDll.whellDll.LogiSteeringInitialize(true));
    }
}

