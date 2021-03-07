package com.jna;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Structure;
import com.sun.jna.WString;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.ptr.IntByReference;

public interface WhellDll extends Library {

    WhellDll whellDll = (WhellDll) Native.load("whell",WhellDll.class);

    //Call this function to initialize if you have already the window handle
    boolean LogiSteeringInitializeWithWindow(boolean ignoreXInputControllers, WinDef.HWND hwnd);

    //Call this function before any other of the following
    boolean LogiSteeringInitialize(boolean ignoreXInputControllers);

    //Get the current SDK Version number
    boolean LogiSteeringGetSdkVersion(IntByReference majorNum, IntByReference minorNum, IntByReference buildNum);

    //Update the status of the controller
    boolean LogiUpdate();

    //Get the state of the controller in the simplified struct DIJOYSTATE2UDK. Use this only if working with UDK DLLBind
    Structure LogiGetStateENGINES(int index);

    //Get the state of the controller in the standard way.
    Structure LogiGetState(int index);

    //Get the computer specific operating system assigned controller GUID at a given index
    boolean LogiGetDevicePath(int index, WString buffer, int  bufferSize);

    //Get the friendly name of the product at index
    boolean LogiGetFriendlyProductName(int index, WString buffer, int  bufferSize);

    //Check if a generic device at index is connected
    boolean LogiIsConnected(int index);

    //Check if the device connected at index is of the same type specified by deviceType
    boolean LogiIsDeviceConnected(int index, int deviceType);

    //Check if the device connected at index is made from the manufacturer specified by manufacturerName
    boolean LogiIsManufacturerConnected(int index, int manufacturerName);

    //Check if the device connected at index is the model specified by modelName
    boolean LogiIsModelConnected(int index, int modelName);

    //Check if the device connected at index is currently triggering the button specified by buttonNbr
    boolean LogiButtonTriggered(int index, int buttonNbr);

    //Check if on the device connected at index has been released the button specified by buttonNbr
    boolean LogiButtonReleased(int index, int buttonNbr);

    //Check if on the device connected at index is currently being pressed the button specified by buttonNbr
    boolean LogiButtonIsPressed(int index, int buttonNbr);

    //Generate non-linear values for the axis of the controller at index
    boolean LogiGenerateNonLinearValues(int index, int nonLinCoeff);

    //Get a non-linear value from a table previously generated
    int LogiGetNonLinearValue(int index, int inputValue);

    //Check if the controller at index has force feedback
    boolean LogiHasForceFeedback(int index);

    //Check if the controller at index is playing the force specified by forceType
    boolean LogiIsPlaying(int index, int forceType);

    //Play the spring force on the controller at index with the specified parameters
    boolean LogiPlaySpringForce(int index, int offsetPercentage, int saturationPercentage, int coefficientPercentage);

    //Stop the spring force on the controller at index
    boolean LogiStopSpringForce(int index);

    //Play the constant force on the controller at index with the specified parameter
    boolean LogiPlayConstantForce(int index, int magnitudePercentage);

    //Stop the constant force on the controller at index
    boolean LogiStopConstantForce(int index);

    //Play the damper force on the controller at index with the specified parameter
    boolean LogiPlayDamperForce(int index, int coefficientPercentage);

    //Stop the damper force on the controller at index
    boolean LogiStopDamperForce(int index);

    //Play the side collision force on the controller at index with the specified parameter
    boolean LogiPlaySideCollisionForce(int index, int magnitudePercentage);

    //Play the frontal collision force on the controller at index with the specified parameter
    boolean LogiPlayFrontalCollisionForce(int index, int magnitudePercentage);

    //Play the dirt road effect on the controller at index with the specified parameter
    boolean LogiPlayDirtRoadEffect(int index, int magnitudePercentage);

    //Stop the dirt road effect on the controller at index
    boolean LogiStopDirtRoadEffect(int index);

    //Play the bumpy road effect on the controller at index with the specified parameter
    boolean LogiPlayBumpyRoadEffect(int index, int magnitudePercentage);

    //Stop the bumpy road effect on the controller at index
    boolean LogiStopBumpyRoadEffect(int index);

    //Play the slippery road effect on the controller at index with the specified parameter
    boolean LogiPlaySlipperyRoadEffect(int index, int magnitudePercentage);

    //Stop the slippery road effect on the controller at index
    boolean LogiStopSlipperyRoadEffect(int index);

    //Play the surface effect on the controller at index with the specified parameter
    boolean LogiPlaySurfaceEffect(int index, int type, int magnitudePercentage, int period);

    //Stop the surface effect on the controller at index
    boolean LogiStopSurfaceEffect(int index);

    //Play the car airborne effect on the controller at index
    boolean LogiPlayCarAirborne(int index);

    //Stop the car airborne effect on the controller at index
    boolean LogiStopCarAirborne(int index);

    //Play the soft stop force on the controller at index with the specified parameter
    boolean LogiPlaySoftstopForce(int index, int usableRangePercentage);

    //Stop the soft stop force on the controller at index
    boolean LogiStopSoftstopForce(int index);

    //Set preferred wheel properties specified by the struct properties
    boolean LogiSetPreferredControllerProperties(Structure properties);

    //Fills the properties parameter with the current controller properties
    //boolean LogiGetCurrentControllerProperties(int index, LogiControllerPropertiesData& properties);

    //get current shifter mode (gated or sequential)
    int LogiGetShifterMode(int index);

    //Sets the operating range in degrees on the controller at the index.
    boolean LogiSetOperatingRange(int index, int range);

    //Gets the current operating range in degrees on the controller at the index.
    boolean LogiGetOperatingRange(int index, IntByReference range);

    //Play the leds on the controller at index applying the specified parameters.
    boolean LogiPlayLeds(int index, float currentRPM, float rpmFirstLedTurnsOn, float rpmRedLine);

    //Sets the operating range in degrees on the DInput device.
    //boolean LogiSetOperatingRangeDInput(LPDIRECTINPUTDEVICE8 deviceHandle, int range);

    //Gets the current operating range in degrees on the DInput device.
   // boolean LogiGetOperatingRangeDInput(LPDIRECTINPUTDEVICE8 deviceHandle, IntByReference range);

    //Play the leds on the DInput device applying the specified parameters.
    //boolean LogiPlayLedsDInput(LPDIRECTINPUTDEVICE8 deviceHandle, float currentRPM, float rpmFirstLedTurnsOn, float rpmRedLine);

    //Call this function to shutdown the SDK and destroy the controller and wheel objects
    void LogiSteeringShutdown();
}
