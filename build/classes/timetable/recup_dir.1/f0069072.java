; Installation inf for the Apple Mobile Device Ethernet driver 
;
; netaapl64.inf
;
; (c) Copyright 2009 Apple, Inc.
;
;
; 

[version]
Signature   = "$Windows NT$"
Class       = Net
ClassGUID   = {4d36e972-e325-11ce-bfc1-08002be10318}
Provider    = %Aapl%
DriverVer=07/15/2013,1.8.5.1
CatalogFile = netaapl64.cat

[Manufacturer]
%Aapl% = Aapl,NTAMD64

[Aapl.NTAMD64]
%Netaapl.DeviceDesc%    = Netaapl.ndi, USB\Vid_05ac&Pid_1292&Mi_02
%Netaapl.DeviceDesc%    = Netaapl.ndi, USB\Vid_05ac&Pid_1294&Mi_02
%Netaapl.DeviceDesc%    = Netaapl.ndi, USB\Vid_05ac&Pid_1297&Mi_02
%Netaapl.DeviceDesc%    = Netaapl.ndi, USB\Vid_05ac&Pid_129A&Mi_02
%Netaapl.DeviceDesc%    = Netaapl.ndi, USB\Vid_05ac&Pid_129C&Mi_02
%Netaapl.DeviceDesc%    = Netaapl.ndi, USB\Vid_05ac&Pid_129F&Mi_02
%Netaapl.DeviceDesc%    = Netaapl.ndi, USB\Vid_05ac&Pid_12A0&Mi_02
%Netaapl.DeviceDesc%    = Netaapl.ndi, USB\Vid_05ac&Pid_12A1&Mi_02
%Netaapl.DeviceDesc%    = Netaapl.ndi, USB\Vid_05ac&Pid_12A2&Mi_02
%Netaapl.DeviceDesc%    = Netaapl.ndi, USB\Vid_05ac&Pid_12A3&Mi_02
%Netaapl.DeviceDesc%    = Netaapl.ndi, USB\Vid_05ac&Pid_12A4&Mi_02
%Netaapl.DeviceDesc%    = Netaapl.ndi, USB\Vid_05ac&Pid_12A5&Mi_02
%Netaapl.DeviceDesc%    = Netaapl.ndi, USB\Vid_05ac&Pid_12A6&Mi_02
%Netaapl.DeviceDesc%    = Netaapl.ndi, USB\Vid_05ac&Pid_12A7&Mi_02
%Netaapl.DeviceDesc%    = Netaapl.ndi, USB\Vid_05ac&Pid_12A8&Mi_02
%Netaapl.DeviceDesc%    = Netaapl.ndi, USB\Vid_05ac&Pid_12A9&Mi_02
%Netaapl.DeviceDesc%    = Netaapl.ndi, USB\Vid_05ac&Pid_12AA&Mi_02
%Netaapl.DeviceDesc%    = Netaapl.ndi, USB\Vid_05ac&Pid_12AB&Mi_02

;-------------------------------------------------------------------------------
; Apple Mobile Device Ethernet
;
[Netaapl.ndi]
Characteristics = 0x4 ; NCF_PHYSICAL
BusType         = 15
AddReg          = Netaapl.Reg
CopyFiles       = Netaapl.CopyFiles

[Netaapl.ndi.Services]
AddService      = Netaapl, 2, Netaapl.Service, Netaapl.EventLog

;-----------------------------------------------------------------------------
; Miniport Common
;
[Netaapl.Reg]
HKR,    ,                         BusNumber,           0, "0"
HKR, Ndi,                         Service,             0, "Netaapl"
HKR, Ndi\Interfaces,              UpperRange,          0, "ndis5"
HKR, Ndi\Interfaces,              LowerRange,          0, "ethernet"


;-----------------------------------------------------------------------------
; DestinationDirs
;
[DestinationDirs]
Netaapl.CopyFiles = 12

[Netaapl.CopyFiles]
netaapl64.sys,,,2

;-----------------------------------------------------------------------------
; Driver and Service Section
;

[Netaapl.Service]
DisplayName     = %Netaapl.Service.DispName%
ServiceType     = 1 ;%SERVICE_KERNEL_DRIVER%
StartType       = 3 ;%SERVICE_DEMAND_START%
ErrorControl    = 1 ;%SERVICE_ERROR_NORMAL%
ServiceBinary   = %12%\netaapl64.sys
LoadOrderGroup  = NDIS
AddReg          = TextModeFlags.Reg

[Netaapl.EventLog]
AddReg = Netaapl.AddEventLog.Reg

[Netaapl.AddEventLog.Reg]
HKR, , EventMessageFile, 0x00020000, "%%SystemRoot%%\System32\netevent.dll"
HKR, , TypesSupported,   0x00010001, 7

[TextModeFlags.Reg]
HKR, , TextModeFlags,    0x00010001, 0x0001

[SourceDisksNames]
1 = %DiskId1%,,,""

[SourceDisksFiles]
netaapl64.sys= 1,,

;
;--- Netaapl.ndi WDF Coinstaller installation ------
;
[DestinationDirs]
Netaapl_CoInstaller_CopyFiles = 11

[Netaapl.ndi.CoInstallers]
AddReg=Netaapl_CoInstaller_AddReg
CopyFiles=Netaapl_CoInstaller_CopyFiles

[Netaapl_CoInstaller_AddReg]
HKR,,CoInstallers32,0x00010000, "wdfcoinstaller01009.dll,WdfCoInstaller"

[Netaapl_CoInstaller_CopyFiles]
wdfcoinstaller01009.dll

[SourceDisksFiles]
wdfcoinstaller01009.dll=1

[Netaapl.ndi.Wdf]
KmdfService = Netaapl, Netaapl_wdfsect
[Netaapl_wdfsect]
KmdfLibraryVersion = 1.9



;-----------------------------------------------------------------------------
; Localizable Strings
;
[Strings]
Aapl                       = "Apple"
Netaapl.DeviceDesc        = "Apple Mobile Device Ethernet"
Netaapl.Service.DispName    = "Apple Mobile Device Ethernet Service"
DiskId1 = "Apple Mobile Device Ethernet Installation Disk #1"

