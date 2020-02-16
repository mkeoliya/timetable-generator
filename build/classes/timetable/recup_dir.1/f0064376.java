;
; Copyright 2014, Broadcom Corporation.
; All Rights Reserved.
;

[version]
Signature       = "$Windows NT$"                ; win10
Class           = Net
ClassGUID       = {4d36e972-e325-11ce-bfc1-08002be10318}
Provider        = %V_BCM%

DriverVer=11/22/2016, 7.35.352.0
CatalogFile     = BCM43XX.CAT
CatalogFile.NTamd64=BCM43XX64.CAT

[Manufacturer]
	%V_BCM% = BROADCOM, NTx86, NTamd64

[ControlFlags]
	ExcludeFromSelect = *

;	Display Name		Section			DeviceID
;	------------		-------			--------

;---------------------------------------------------------------
; x64 (AMD64, Intel EM64T) - Win10
;
[BROADCOM.NTamd64]
        %BCM1530HM4L_DeviceDesc% = BCM43XNG_NT64, PCI\VEN_14E4&DEV_4359&SUBSYS_00111028
        %BCM1540HM4L_DeviceDesc% = BCM43XNG_NT64, PCI\VEN_14E4&DEV_4359&SUBSYS_00141028
        %BCM1550HM4L_DeviceDesc% = BCM43XAC_NT64, PCI\VEN_14E4&DEV_43B1&SUBSYS_00171028
        %BCM1560HM4L_DeviceDesc% = BCM43XAC_NT64, PCI\VEN_14E4&DEV_43B1&SUBSYS_00191028
        %BCM1704HMD_DeviceDesc%  = BCM43XNG_NT64, PCI\VEN_14E4&DEV_4365&SUBSYS_00161028
        %BCM1708HMD_DeviceDesc%  = BCM43XNG_NT64, PCI\VEN_14E4&DEV_4365&SUBSYS_00181028

[BROADCOM.NTx86]
        %BCM1530HM4L_DeviceDesc% = BCM43XNG_NT64, PCI\VEN_14E4&DEV_4359&SUBSYS_00111028
        %BCM1540HM4L_DeviceDesc% = BCM43XNG_NT64, PCI\VEN_14E4&DEV_4359&SUBSYS_00141028
        %BCM1550HM4L_DeviceDesc% = BCM43XAC_NT64, PCI\VEN_14E4&DEV_43B1&SUBSYS_00171028
        %BCM1560HM4L_DeviceDesc% = BCM43XAC_NT64, PCI\VEN_14E4&DEV_43B1&SUBSYS_00191028
        %BCM1704HMD_DeviceDesc%  = BCM43XNG_NT64, PCI\VEN_14E4&DEV_4365&SUBSYS_00161028
        %BCM1708HMD_DeviceDesc%  = BCM43XNG_NT64, PCI\VEN_14E4&DEV_4365&SUBSYS_00181028

[BCM43XAC_NT64.NTamd64]
	Include         = netvwifibus.inf
	Needs           = VWiFiBus.CopyFiles
	*IfType         = 71    ; IF_TYPE_IEEE80211
	*MediaType      = 16    ; NdisMediumNative802_11
	*PhysicalMediaType = 9  ; NdisPhysicalMediumNative802_11
	Characteristics = 0x84  ; NCF_PHYSICAL | NCF_HAS_UI
	BusType         = 5	; PCI bus
	AddReg          = BCM43XX_NT64.reg, BCM43XX.brcm.NTamd64.reg, common.reg, common.vista.reg, gn.options.reg,\
                          BCMIHV.reg.NTamd64, wowl.capabilities.enabled.reg, wowl.std_keywords.reg, ac.options.reg
	CopyFiles       = BCM43XX_NT64.files.NTamd64, BCMIHV.files.NTamd64
	RegisterDlls    = BCMIHVUI.regsrv.NTamd64

[BCM43XNG_NT64.NTamd64]
        Include         = netvwifibus.inf
        Needs           = VWiFiBus.CopyFiles
        *IfType         = 71    ; IF_TYPE_IEEE80211
        *MediaType      = 16    ; NdisMediumNative802_11
        *PhysicalMediaType = 9  ; NdisPhysicalMediumNative802_11
        Characteristics = 0x84  ; NCF_PHYSICAL | NCF_HAS_UI
        BusType         = 5                     ; PCI bus
        AddReg          = BCM43XX_NT64.reg, BCM43XX.brcm.NTamd64.reg, common.reg, common.vista.reg, gn.options.reg,\
                          gn40.options.reg,\
                          BCMIHV.reg.NTamd64, wowl.capabilities.disabled.reg
        CopyFiles       = BCM43XX_NT64.files.NTamd64, BCMIHV.files.NTamd64
		RegisterDlls    = BCMIHVUI.regsrv.NTamd64

[BCM43XNM_NT64.NTamd64]
        Include         = netvwifibus.inf
        Needs           = VWiFiBus.CopyFiles
        *IfType         = 71    ; IF_TYPE_IEEE80211
        *MediaType      = 16    ; NdisMediumNative802_11
        *PhysicalMediaType = 9  ; NdisPhysicalMediumNative802_11
        Characteristics = 0x84  ; NCF_PHYSICAL | NCF_HAS_UI
        BusType         = 5     ; PCI bus
        AddReg          = BCM43XX_NT64.reg, BCM43XX.brcm.NTamd64.reg, common.reg, common.vista.reg, bagn.options.reg,\
                          bagn40.options.reg,\
                          BCMIHV.reg.NTamd64, wowl.capabilities.disabled.reg
        CopyFiles       = BCM43XX_NT64.files.NTamd64, BCMIHV.files.NTamd64
		RegisterDlls    = BCMIHVUI.regsrv.NTamd64


[BCM43XNG_NT64.NTamd64.Services]
	Include		= netvwifibus.inf
	Needs           = VWiFiBus.Services
	AddService = BCMWL63A, 2, BCM43XX_NT64.Service.NTamd64, common.EventLog

[BCM43XNG_NT64.NTamd64.HW]
	Include = netvwifibus.inf
	Needs   = VWiFiBus.PnPFilterRegistration


[BCM43XNM_NT64.NTamd64.Services]
	Include		= netvwifibus.inf
	Needs           = VWiFiBus.Services
	AddService = BCMWL63A, 2, BCM43XX_NT64.Service.NTamd64, common.EventLog

[BCM43XNM_NT64.NTamd64.HW]
	Include = netvwifibus.inf
	Needs   = VWiFiBus.PnPFilterRegistration

[BCM43XAC_NT64.NTamd64.Services]
	Include		= netvwifibus.inf
	Needs           = VWiFiBus.Services
	AddService = BCMWL63A, 2, BCM43XX_NT64.Service.NTamd64, common.EventLog

[BCM43XAC_NT64.NTamd64.HW]
	Include = netvwifibus.inf
	Needs   = VWiFiBus.PnPFilterRegistration

[BCM43XAC_NT64.NTx86]
	Include         = netvwifibus.inf
	Needs           = VWiFiBus.CopyFiles
	*IfType         = 71    ; IF_TYPE_IEEE80211
	*MediaType      = 16    ; NdisMediumNative802_11
	*PhysicalMediaType = 9  ; NdisPhysicalMediumNative802_11
	Characteristics = 0x84  ; NCF_PHYSICAL | NCF_HAS_UI
	BusType         = 5	; PCI bus
	AddReg          = BCM43XX_NT64.reg, BCM43XX.brcm.NTx86.reg, common.reg, common.vista.reg, gn.options.reg,\
                          BCMIHV.reg.NTx86, wowl.capabilities.enabled.reg, wowl.std_keywords.reg, ac.options.reg
	CopyFiles       = BCM43XX_NT64.files.NTx86, BCMIHV.files.NTx86
	RegisterDlls    = BCMIHVUI.regsrv.NTx86

[BCM43XNM_NT64.NTx86]
        Include         = netvwifibus.inf
        Needs           = VWiFiBus.CopyFiles
        *IfType         = 71    ; IF_TYPE_IEEE80211
        *MediaType      = 16    ; NdisMediumNative802_11
        *PhysicalMediaType = 9  ; NdisPhysicalMediumNative802_11
        Characteristics = 0x84  ; NCF_PHYSICAL | NCF_HAS_UI
        BusType         = 5     ; PCI bus
        AddReg          = BCM43XX_NT64.reg, BCM43XX.brcm.NTx86.reg, common.reg, common.vista.reg, bagn.options.reg,\
                          bagn40.options.reg,\
                          BCMIHV.reg.NTx86, wowl.capabilities.disabled.reg
        CopyFiles       = BCM43XX_NT64.files.NTx86, BCMIHV.files.NTx86
		RegisterDlls    = BCMIHVUI.regsrv.NTx86

[BCM43XNG_NT64.NTx86]
        Include         = netvwifibus.inf
        Needs           = VWiFiBus.CopyFiles
        *IfType         = 71    ; IF_TYPE_IEEE80211
        *MediaType      = 16    ; NdisMediumNative802_11
        *PhysicalMediaType = 9  ; NdisPhysicalMediumNative802_11
        Characteristics = 0x84  ; NCF_PHYSICAL | NCF_HAS_UI
        BusType         = 5                     ; PCI bus
        AddReg          = BCM43XX_NT64.reg, BCM43XX.brcm.NTx86.reg, common.reg, common.vista.reg, gn.options.reg, gn40.options.reg, \
                          BCMIHV.reg.NTx86, wowl.capabilities.disabled.reg
        CopyFiles       = BCM43XX_NT64.files.NTx86, BCMIHV.files.NTx86
		RegisterDlls    = BCMIHVUI.regsrv.NTx86


[BCM43XAC_NT64.NTx86.Services]
	Include = netvwifibus.inf
	Needs   = VWiFiBus.Services
	AddService = BCMWL63, 2, BCM43XX_NT64.Service.NTx86, common.EventLog

[BCM43XAC_NT64.NTx86.HW]
	Include = netvwifibus.inf
	Needs   = VWiFiBus.PnPFilterRegistration

[BCMIHV.files.NTamd64]
	bcmihvsrv64.dll,,,6
	bcmihvui64.dll,,,6

[BCMIHV.files.NTx86]
	bcmihvsrv.dll,,,6
	bcmihvui.dll,,,6

;
; IHV UI registration
;
[BCMIHVUI.regsrv.NTamd64]
	11,,bcmihvui64.dll,1

[BCMIHVUI.regsrv.NTx86]
	11,,bcmihvui.dll,1

[BCM43XNM_NT64.NTx86.Services]
	Include = netvwifibus.inf
	Needs   = VWiFiBus.Services
	AddService = BCMWL63, 2, BCM43XX_NT64.Service.NTx86, common.EventLog

[BCM43XNM_NT64.NTx86.HW]
	Include = netvwifibus.inf
	Needs   = VWiFiBus.PnPFilterRegistration

[BCM43XNG_NT64.NTx86.Services]
	Include = netvwifibus.inf
	Needs   = VWiFiBus.Services
	AddService = BCMWL63, 2, BCM43XX_NT64.Service.NTx86, common.EventLog

[BCM43XNG_NT64.NTx86.HW]
	Include = netvwifibus.inf
	Needs   = VWiFiBus.PnPFilterRegistration

[BCM43XX_NT64.reg]
	; Ndis Info
	; Interfaces
	HKR,    Ndi\Interfaces, UpperRange,     ,       "ndis5"
	HKR,    Ndi\Interfaces, LowerRange,     ,       "ethernet,wlan,vwifi"

[BCM43XX.brcm.NTamd64.reg]
	HKR,    Ndi,    HelpText,               ,       %BCM43XX_HELP%
	HKR,    Ndi,    Service,                0,      "BCMWL63A"

[BCM43XX.brcm.NTx86.reg]
	HKR,    Ndi,    HelpText,               ,       %BCM43XX_HELP%
	HKR,    Ndi,    Service,                0,      "BCMWL63"

[common.EventLog]
	AddReg = common.AddEventLog.reg

[common.AddEventLog.reg]
	HKR,    ,       EventMessageFile,       0x00020000,     "%%SystemRoot%%\System32\netevent.dll"
	HKR,    ,       TypesSupported,         0x00010001,     7

; 11 == %windir%/system32
; 12 == %windir%/system32/drivers

[BCM43XX_NT64.Service.NTamd64]
	DisplayName     = %BCM43XX_Service_DispName%
	ServiceType     = 1                     ; %SERVICE_KERNEL_DRIVER%
	StartType       = 3                     ; %SERVICE_DEMAND_START%
	ErrorControl    = 1                     ; %SERVICE_ERROR_NORMAL%
	ServiceBinary   = %12%\bcmwl63a.sys
	LoadOrderGroup  = NDIS

[BCM43XX_NT64.files.NTamd64]
	bcmwl63a.sys,,,6

[BCM43XX_NT64.Service.NTx86]
	DisplayName     = %BCM43XX_Service_DispName%
	ServiceType     = 1                     ; %SERVICE_KERNEL_DRIVER%
	StartType       = 3                     ; %SERVICE_DEMAND_START%
	ErrorControl    = 1                     ; %SERVICE_ERROR_NORMAL%
	ServiceBinary   = %12%\bcmwl63.sys
	LoadOrderGroup  = NDIS

[BCM43XX_NT64.files.NTx86]
	bcmwl63.sys,,,6

; 11 == %windir%/system32
; 12 == %windir%/system32/drivers

[DestinationDirs]
	DefaultDestDir                                = 11
	BCM43XX_NT64.files.NTamd64                = 12
	BCM43XX_NT64.files.NTx86                  = 12
	BCMIHV.files.NTx86                            = 11
	BCMIHV.files.NTamd64                          = 11

[SourceDisksNames]
	1=%BCM43XX_DiskName%,,

; for Win8x specify BCMWL63a.SYS
[SourceDisksFiles.amd64]
	bcmwl63a.sys=1
	bcmihvsrv64.dll=1
	bcmihvui64.dll=1

[SourceDisksFiles.x86]
	bcmwl63.sys=1
	bcmihvsrv.dll=1
	bcmihvui.dll=1


;Uninstall
[Cleanup]
	UnregisterDlls	= BCMIHVUI.regsrv.NTamd64, BCMIHVUI.regsrv.NTx86
	DelFiles	= BCMIHV.files.NTamd64, BCMIHV.files.NTx86

[BCMIHV.reg.NTamd64]
	HKR, Ndi\IHVExtensions, ExtensibilityDLL,       0,  "%%SystemRoot%%\System32\bcmihvsrv64.dll"
	HKR, Ndi\IHVExtensions, UIExtensibilityCLSID,   0,  "{AAA6DEE9-31B9-4f18-AB39-82EF9B06EB73}"
	HKR, Ndi\IHVExtensions, AdapterOUI,             0x00010001, 0x001018

[BCMIHV.reg.NTx86]
	HKR, Ndi\IHVExtensions, ExtensibilityDLL,       0,  "%%SystemRoot%%\System32\bcmihvsrv.dll"
	HKR, Ndi\IHVExtensions, UIExtensibilityCLSID,   0,  "{AAA6DEE9-31B9-4f18-AB39-82EF9B06EB73}"
	HKR, Ndi\IHVExtensions, AdapterOUI,             0x00010001, 0x001018

;common for WinVista, but excluded in WinXP and older
[common.vista.reg]
	HKR,    Ndi\params\*PriorityVLANTag, ParamDesc, 0,      %PriorityVLANTag%
	HKR,    Ndi\params\*PriorityVLANTag, type,      0,      "enum"
	HKR,    Ndi\params\*PriorityVLANTag\enum, "0",  0,      %PriorityAndVLANDisabled%
	HKR,    Ndi\params\*PriorityVLANTag\enum, "1",  0,      %PriorityEnabled%
	HKR,    Ndi\params\*PriorityVLANTag\enum, "2",  0,      %VLANEnabled%
	HKR,    Ndi\params\*PriorityVLANTag\enum, "3",  0,      %PriorityAndVLANEnabled%
	HKR,    Ndi\params\*PriorityVLANTag,default,,"0"
	HKR,    Ndi\params\*PriorityVLANTag,optional,,"0"
	HKR,    ,"PowerSaveMode",       0,      "2"

;common for all platform
[common.reg]
	HKR, ,"EnableSoftAP",		0,	"1"
	HKR, ,"EnableAutoConnect", 0, "0"

	HKR,    Ndi\params\MPC, ParamDesc,              0,      %MinimumPowerConsumption%
	HKR,    Ndi\params\MPC, type,                   0,      "enum"
	HKR,    Ndi\params\MPC\enum, "0",               0,      %Disabled%
	HKR,    Ndi\params\MPC\enum, "1",               0,      %Enabled%
	HKR,    Ndi\params\MPC,default,,"1"

	HKR,    Ndi\params\frag, ParamDesc,     0,      %FragmentationThreshold%
	HKR,    Ndi\params\frag,type,0,"dword"
	HKR,    Ndi\params\frag,min,,"256"
	HKR,    Ndi\params\frag,max,,"2346"
	HKR,    Ndi\params\frag,default,,"2346"

	HKR,    Ndi\params\rts, ParamDesc,      0,      %RTSThreshold%
	HKR,    Ndi\params\rts,type,0,"dword"
	HKR,    Ndi\params\rts,min,,"0"
	HKR,    Ndi\params\rts,max,,"2347"
	HKR,    Ndi\params\rts,default,,"2347"

	HKR,    Ndi\params\NetworkAddress, ParamDesc,   0, %LocallyAdministeredMACAddress%
	HKR,    Ndi\params\NetworkAddress, type,        0, "edit"
	HKR,    Ndi\params\NetworkAddress, LimitText,   0, "12"
	HKR,    Ndi\params\NetworkAddress, UpperCase,   0, "1"
	HKR,    Ndi\params\NetworkAddress, default,     0, ""
	HKR,    Ndi\params\NetworkAddress, optional,    0, "1"

	HKR,    Ndi\params\PwrOut, ParamDesc,   0,      %PowerOutput%
	HKR,    Ndi\params\PwrOut, type,                0,      "enum"
	HKR,    Ndi\params\PwrOut\enum, "100",  0,      "100%%"
	HKR,    Ndi\params\PwrOut\enum, "75",   0,      "75%%"
	HKR,    Ndi\params\PwrOut\enum, "50",   0,      "50%%"
	HKR,    Ndi\params\PwrOut\enum, "25",   0,      "25%%"
	HKR,    Ndi\params\PwrOut,default,,"100"

	HKR,    Ndi\params\FrameBursting, ParamDesc,    0,      %XPress_Technology%
	HKR,    Ndi\params\FrameBursting, type,         0,      "enum"
	HKR,    Ndi\params\FrameBursting\enum, "0",             0,      %Disabled%
	HKR,    Ndi\params\FrameBursting\enum, "1",             0,      %Enabled%
	HKR,    Ndi\params\FrameBursting,default,,"0"

	HKR,    Ndi\params\BTCoexist, ParamDesc,        0,      %BlueToothCollaboration%
	HKR,    Ndi\params\BTCoexist, type,             0,      "enum"
	HKR,    Ndi\params\BTCoexist\enum, "0", 0,      %Disable%
	HKR,    Ndi\params\BTCoexist\enum, "1", 0,      %Enable%
	HKR,    Ndi\params\BTCoexist\enum, "3", 0,      %Auto%
	HKR,    Ndi\params\BTCoexist,default,,"3"

	HKR,					,"WowlKeyRot", 0, "1"
	HKR,                                    ,"WEP", 0,      ""
	HKR,                                    ,"NetworkType", 0,      "-1"
	HKR,                                    ,"SSID",        0,      ""

	HKR,                                    ,"ledbh0",      0,      "-1"
	HKR,                                    ,"ledbh1",      0,      "-1"
	HKR,                                    ,"ledbh2",      0,      "-1"
	HKR,                                    ,"ledbh3",      0,      "-1"
	HKR,                                    ,"ledblinkslow",        0,      "-1"
	HKR,                                    ,"ledblinkmed", 0,      "-1"
	HKR,                                    ,"ledblinkfast",        0,      "-1"
	HKR,                                    ,"leddc",       0,      "0"

	HKR,                                    ,"scan_channel_time",   0,      "-1"
	HKR,                                    ,"scan_unassoc_time",   0,      "-1"
	HKR,                                    ,"scan_home_time",              0,      "-1"
	HKR,                                    ,"scan_passes",                 0,      "-1"

	HKR,                                    ,"BadFramePreempt",             0,      "0"

	HKR,                                    ,"Interference_Mode",           0,      "-1"

	HKR,                                    ,"ccx_rm",                      0,      "1"
	HKR,                                    ,"ccx_rm_limit",                0,      "300"

	HKR,                                    ,"EFCEnable",           0,      "0"

	HKR,    Ndi\params\antdiv, ParamDesc,   0,      %AntennaDiversity%
	HKR,    Ndi\params\antdiv, type,        0,      "enum"
	HKR,    Ndi\params\antdiv\enum, "-1",   0,      %Auto%
	HKR,    Ndi\params\antdiv\enum, "0",    0,      %Main%
	HKR,    Ndi\params\antdiv\enum, "1",    0,      %Aux%
	HKR,	Ndi\params\antdiv,default,,"-1"

	HKR,    Ndi\params\WME, ParamDesc,      0,      %WME%
	HKR,    Ndi\params\WME, type,           0,      "enum"
	HKR,    Ndi\params\WME\enum, "-1",      0,      %Auto%
	HKR,    Ndi\params\WME\enum, "1",       0,      %Enabled%
	HKR,    Ndi\params\WME\enum, "0",       0,      %Disabled%
	HKR,    Ndi\params\WME,default,,"-1"

; the next line forces upgrade installation to configure WME value to be -1

	HKR,    ,"WME",0,"-1"

	HKR,    Ndi\params\ListenInterval, ParamDesc,     0,      %ListenInterval%
	HKR,    Ndi\params\ListenInterval,type,0,"dword"
	HKR,    Ndi\params\ListenInterval,min,,"1"
	HKR,    Ndi\params\ListenInterval,max,,"100"
	HKR,    Ndi\params\ListenInterval,default,,"1"

	HKR,    Ndi\params\D2ListenInterval, ParamDesc,     0,      %D2ListenInterval%
	HKR,    Ndi\params\D2ListenInterval,type,0,"dword"
	HKR,    Ndi\params\D2ListenInterval,min,,"1"
	HKR,    Ndi\params\D2ListenInterval,max,,"100"
	HKR,    Ndi\params\D2ListenInterval,default,,"5"

	HKR,    Ndi\params\WFDChannelNumber, ParamDesc,     0,      %WFDChannelNumber%
	HKR,    Ndi\params\WFDChannelNumber,type,0,"dword"
	HKR,    Ndi\params\WFDChannelNumber,min,,"1"
	HKR,    Ndi\params\WFDChannelNumber,max,,"11"
	HKR,    Ndi\params\WFDChannelNumber,default,,"11"

	HKR,    Ndi\params\EnableLTR, ParamDesc,0, %EnableLTR%
	HKR,    Ndi\params\EnableLTR, type,     0,         "enum"
	HKR,    Ndi\params\EnableLTR\enum, "0", 0, %Disabled%
	HKR,    Ndi\params\EnableLTR\enum, "1", 0, %Enabled%
	HKR,    Ndi\params\EnableLTR,default,,"1"

	HKR,    Ndi\params\LTR_ActiveValue, ParamDesc,     0,      %LTR_ActiveValue%
	HKR,    Ndi\params\LTR_ActiveValue,type,0,"dword"
	HKR,    Ndi\params\LTR_ActiveValue,min,,"0"
	HKR,    Ndi\params\LTR_ActiveValue,max,,"1023"
	HKR,    Ndi\params\LTR_ActiveValue,default,,"60"

	HKR,                                    ,"mchan_algo_wfd",                0,      "1"
	HKR,                                    ,"mchan_bw_wfd",                0,      "40"

	HKR, Ndi\params\BWCap2G, ParamDesc, 0, "2G Bandwidth Capability"
	HKR, Ndi\params\BWCap2G, type, 0, "enum"
	HKR, Ndi\params\BWCap2G\enum, "0", 0, "2.4G: 20MHz"
	HKR, Ndi\params\BWCap2G\enum, "1", 0, "2.4G: 20/40MHz"
	HKR, Ndi\params\BWCap2G,default,,"0"

[gn.options.reg]
	HKR,    Ndi\params\RoamTrigger, ParamDesc,      0,      %RoamingDecision%
	HKR,    Ndi\params\RoamTrigger, type,           0,      "enum"
	HKR,    Ndi\params\RoamTrigger\enum, "3",       0,      %Auto%
	HKR,    Ndi\params\RoamTrigger\enum, "1",       0,      %OptimizeBandwidth%
	HKR,    Ndi\params\RoamTrigger\enum, "0",       0,      %Default%
	HKR,    Ndi\params\RoamTrigger\enum, "2",       0,      %OptimizeDistance%
	HKR,    Ndi\params\RoamTrigger,default,,"3"

	HKR,    Ndi\params\PLCPHeader, ParamDesc,       0,      %BSSPLCPHeader%
	HKR,    Ndi\params\PLCPHeader, type,            0,      "enum"
	HKR,    Ndi\params\PLCPHeader\enum, "-1",       0,      %Long%
	HKR,    Ndi\params\PLCPHeader\enum, "0",        0,      %AutoShortLong%
	HKR,    Ndi\params\PLCPHeader,default,,"0"

	HKR,    Ndi\params\Rate, ParamDesc,     0,      %Rate%
	HKR,    Ndi\params\Rate, type,          0,      "enum"
	HKR,    Ndi\params\Rate\enum, "0",      0,      %Usebestrate%
	HKR,    Ndi\params\Rate\enum, "2",      0,      " 1"
	HKR,    Ndi\params\Rate\enum, "4",      0,      " 2"
	HKR,    Ndi\params\Rate\enum, "11",     0,      " 5.5"
	HKR,    Ndi\params\Rate\enum, "12",     0,      " 6"
	HKR,    Ndi\params\Rate\enum, "18",     0,      " 9"
	HKR,    Ndi\params\Rate\enum, "22",     0,      "11"
	HKR,    Ndi\params\Rate\enum, "24",     0,      "12"
	HKR,    Ndi\params\Rate\enum, "36",     0,      "18"
	HKR,    Ndi\params\Rate\enum, "48",     0,      "24"
	HKR,    Ndi\params\Rate\enum, "72",     0,      "36"
	HKR,    Ndi\params\Rate\enum, "96",     0,      "48"
	HKR,    Ndi\params\Rate\enum, "108",0,  "54"
	HKR,    Ndi\params\Rate,default,,"0"

	HKR,    Ndi\params\Intolerant, ParamDesc,       0,      %Intolerant%
	HKR,    Ndi\params\Intolerant, type,         0,      "enum"
	HKR,    Ndi\params\Intolerant\enum, "0",     0,      %Disabled%
	HKR,    Ndi\params\Intolerant\enum, "1",     0,      %Enabled%
	HKR,    Ndi\params\Intolerant,default,,"0"

	HKR,    Ndi\params\OBSSCoex, ParamDesc, 0,      %OBSSCoex%
	HKR,    Ndi\params\OBSSCoex, type,      0,      "enum"
	HKR,    Ndi\params\OBSSCoex\enum, "0",  0,      %Disabled%
	HKR,    Ndi\params\OBSSCoex\enum, "1",  0,      %Enabled%
	HKR,    Ndi\params\OBSSCoex\enum, "-1", 0,      %Auto%
	HKR,    Ndi\params\OBSSCoex,default,,"-1"

	HKR,    Ndi\params\11NPreamble, ParamDesc,  0,  "802.11n Preamble"
	HKR,    Ndi\params\11NPreamble, type,           0, "enum"
	HKR,    Ndi\params\11NPreamble\enum, "-1",      0, %Auto%
	HKR,    Ndi\params\11NPreamble\enum, "0",       0, %Mixed_Mode%
	HKR,    Ndi\params\11NPreamble,default,,"-1"

	HKR,	Ndi\params\ShortGI, ParamDesc,  0,	%Short_GI%
	HKR,	Ndi\params\ShortGI, type,		0, "enum"
	HKR,	Ndi\params\ShortGI\enum, "-1",	0,	%Auto%
	HKR,	Ndi\params\ShortGI\enum, "0",	0,	%Disabled%
	HKR,	Ndi\params\ShortGI,default,,"-1"


	; option to override antenna selection, -1: no override, 0: no selection
	HKR,                                    ,"mimo_antsel", 0,      "-1"

; options for 20MHz band for n
[gn40.options.reg]
	HKR,	Ndi\params\BandwidthCap, ParamDesc,     0,      %BandwidthCapability%
	HKR,	Ndi\params\BandwidthCap, type,          0,      "enum"
	HKR,	Ndi\params\BandwidthCap\enum, "0",      0,      "11b/g:20MHz"
	HKR,	Ndi\params\BandwidthCap\enum, "1",      0,      "11b/g:20/40MHz"
	HKR,	Ndi\params\BandwidthCap,default,,"0"

; options for 40MHz band for n
[bagn40.options.reg]
	HKR,	Ndi\params\BandwidthCap, ParamDesc,     0,      %BandwidthCapability%
	HKR,	Ndi\params\BandwidthCap, type,          0,      "enum"
	HKR,	Ndi\params\BandwidthCap\enum, "0",      0,      "11a/b/g:20MHz"
	HKR,	Ndi\params\BandwidthCap\enum, "1",      0,      "11a/b/g:20/40MHz"
	HKR,	Ndi\params\BandwidthCap\enum, "2",      0,      "11a:20/40;11bg:20MHz"
	HKR,	Ndi\params\BandwidthCap,default,,"2"

[bagn.options.reg]
	HKR,	Ndi\params\11HNetworks, ParamDesc, 0,	"802.11h+d"
	HKR,	Ndi\params\11HNetworks, type,		0, "enum"
	HKR,	Ndi\params\11HNetworks\enum, "1",	0, %Loose_11h%
	HKR,	Ndi\params\11HNetworks\enum, "2",	0, %Strict_11h%
	HKR,	Ndi\params\11HNetworks,default,,"1"

	HKR,	Ndi\params\RoamTrigger, ParamDesc,	0,	%RoamingDecision%
	HKR,	Ndi\params\RoamTrigger, type,		0,	"enum"
	HKR,	Ndi\params\RoamTrigger\enum, "3",	0,	%Auto%
	HKR,	Ndi\params\RoamTrigger\enum, "1",	0,	%OptimizeBandwidth%
	HKR,	Ndi\params\RoamTrigger\enum, "0",	0,	%Default%
	HKR,	Ndi\params\RoamTrigger\enum, "2",	0,	%OptimizeDistance%
	HKR,	Ndi\params\RoamTrigger,default,,"3"

	HKR,	Ndi\params\PLCPHeader, ParamDesc,	0,	%BSSPLCPHeader%
	HKR,	Ndi\params\PLCPHeader, type,		0,	"enum"
	HKR,	Ndi\params\PLCPHeader\enum, "-1",	0,	%Long%
	HKR,	Ndi\params\PLCPHeader\enum, "0",	0,	%AutoShortLong%
	HKR,	Ndi\params\PLCPHeader,default,,"0"

	HKR,	Ndi\params\band, ParamDesc,	0,	%DisableBands%
	HKR,	Ndi\params\band, type,		0,	"enum"
	HKR,	Ndi\params\band\enum, "0",	0,	%None%
	HKR,	Ndi\params\band\enum, "1",	0,	%Disable80211gb%
	HKR,	Ndi\params\band\enum, "2",	0,	%Disable80211a%
	HKR,	Ndi\params\band,default,,"0"

	HKR,	Ndi\params\BandPref, ParamDesc,	0,	%BandPreference%
	HKR,	Ndi\params\BandPref, type,		0,	"enum"
	HKR,	Ndi\params\BandPref\enum, "0",	0,	%None%
	HKR,	Ndi\params\BandPref\enum, "1",	0,	%Prefer80211a%
	HKR,	Ndi\params\BandPref\enum, "2",	0,	%Prefer80211gb%
	HKR,	Ndi\params\BandPref,default,,"0"

	HKR,	Ndi\params\RateA, ParamDesc,	0,	%Rate_802_11a%
	HKR,	Ndi\params\RateA, type,		0,	"enum"
	HKR,	Ndi\params\RateA\enum, "0",	0,	%Usebestrate%
	HKR,	Ndi\params\RateA\enum, "12",	0,	" 6"
	HKR,	Ndi\params\RateA\enum, "18",	0,	" 9"
	HKR,	Ndi\params\RateA\enum, "24",	0,	"12"
	HKR,	Ndi\params\RateA\enum, "36",	0,	"18"
	HKR,	Ndi\params\RateA\enum, "48",	0,	"24"
	HKR,	Ndi\params\RateA\enum, "72",	0,	"36"
	HKR,	Ndi\params\RateA\enum, "96",	0,	"48"
	HKR,	Ndi\params\RateA\enum, "108",0,	"54"
	HKR,	Ndi\params\RateA,default,,"0"

	HKR,	Ndi\params\Rate, ParamDesc,	0,	%Rate_802_11bg%
	HKR,	Ndi\params\Rate, type,		0,	"enum"
	HKR,	Ndi\params\Rate\enum, "0",	0,	%Usebestrate%
	HKR,	Ndi\params\Rate\enum, "2",	0,	" 1"
	HKR,	Ndi\params\Rate\enum, "4",	0,	" 2"
	HKR,	Ndi\params\Rate\enum, "11",	0,	" 5.5"
	HKR,	Ndi\params\Rate\enum, "12",	0,	" 6"
	HKR,	Ndi\params\Rate\enum, "18",	0,	" 9"
	HKR,	Ndi\params\Rate\enum, "22",	0,	"11"
	HKR,	Ndi\params\Rate\enum, "24",	0,	"12"
	HKR,	Ndi\params\Rate\enum, "36",	0,	"18"
	HKR,	Ndi\params\Rate\enum, "48",	0,	"24"
	HKR,	Ndi\params\Rate\enum, "72",	0,	"36"
	HKR,	Ndi\params\Rate\enum, "96",	0,	"48"
	HKR,	Ndi\params\Rate\enum, "108",0,	"54"
	HKR,	Ndi\params\Rate,default,,"0"

	HKR,	Ndi\params\ApCompatMode, ParamDesc,	0,	%ApCompatibilityMode%
	HKR,	Ndi\params\ApCompatMode, type,		0,	"enum"
	HKR,	Ndi\params\ApCompatMode\enum, "1",	0,	%BroaderCompat%
	HKR,	Ndi\params\ApCompatMode\enum, "0",	0,	%HigherPerf%
	HKR,	Ndi\params\ApCompatMode,default,,"0"

	HKR,	Ndi\params\Intolerant, ParamDesc,	0,      %Intolerant%
	HKR,	Ndi\params\Intolerant, type,         0,      "enum"
	HKR,	Ndi\params\Intolerant\enum, "0",     0,      %Disabled%
	HKR,	Ndi\params\Intolerant\enum, "1",     0,      %Enabled%
	HKR,	Ndi\params\Intolerant,default,,"0"

	HKR,	Ndi\params\OBSSCoex, ParamDesc,	0,	%OBSSCoex%
	HKR,	Ndi\params\OBSSCoex, type,	0,	"enum"
	HKR,	Ndi\params\OBSSCoex\enum, "0",	0,	%Disabled%
	HKR,	Ndi\params\OBSSCoex\enum, "1",	0,	%Enabled%
	HKR,	Ndi\params\OBSSCoex\enum, "-1", 0,      %Auto%
	HKR,	Ndi\params\OBSSCoex,default,,"-1"

	HKR,	Ndi\params\11NPreamble, ParamDesc,  0,	%802_11n_Preamble%
	HKR,	Ndi\params\11NPreamble, type,		0, "enum"
	HKR,	Ndi\params\11NPreamble\enum, "-1",	0, %Auto%
	HKR,	Ndi\params\11NPreamble\enum, "0",	0, %Mixed_Mode%
	HKR,	Ndi\params\11NPreamble,default,,"-1"

	HKR,	Ndi\params\ShortGI, ParamDesc,  0,	%Short_GI%
	HKR,	Ndi\params\ShortGI, type,	0,	"enum"
	HKR,	Ndi\params\ShortGI\enum, "-1",	0,	%Auto%
	HKR,	Ndi\params\ShortGI\enum, "0",	0,	%Disabled%
	HKR,	Ndi\params\ShortGI,default,,"-1"

[wowl.capabilities.enabled.reg]
        HKR,,   "WakeUpCapabilities", 0x00010001, "0xffffffff"

[wowl.capabilities.disabled.reg]
        HKR,,   "WakeUpCapabilities", 0x00010001, "0x00000000"

[wowl.std_keywords.reg]
        HKR, Ndi\params\*WakeOnMagicPacket, ParamDesc,  0, %WakeOnMagicPacket%
        HKR, Ndi\params\*WakeOnMagicPacket, type,       0, "enum"
        HKR, Ndi\params\*WakeOnMagicPacket\enum,        "0", 0, %Disabled%
        HKR, Ndi\params\*WakeOnMagicPacket\enum,        "1", 0, %Enabled%
        HKR, Ndi\params\*WakeOnMagicPacket,default,,    "1"
        HKR, Ndi\params\*WakeOnMagicPacket,optional,,   "0"

        HKR, Ndi\params\*WakeOnPattern, ParamDesc,      0, %WakeOnPatternMatch%
        HKR, Ndi\params\*WakeOnPattern, type,           0, "enum"
        HKR, Ndi\params\*WakeOnPattern\enum,            "0", 0, %Disabled%
        HKR, Ndi\params\*WakeOnPattern\enum,            "1", 0, %Enabled%
        HKR, Ndi\params\*WakeOnPattern,default,,        "1"
        HKR, Ndi\params\*WakeOnPattern,optional,,       "0"

        HKR, Ndi\params\*PMARPOffload, ParamDesc,       0, %ARPOffload%
        HKR, Ndi\params\*PMARPOffload, type,            0, "enum"
        HKR, Ndi\params\*PMARPOffload\enum,             "0", 0, %Disabled%
        HKR, Ndi\params\*PMARPOffload\enum,             "1", 0, %Enabled%
        HKR, Ndi\params\*PMARPOffload,default,,         "1"
        HKR, Ndi\params\*PMARPOffload,optional,,        "0"

        HKR, Ndi\params\*PMNSOffload, ParamDesc,        0, %NSOffload%
        HKR, Ndi\params\*PMNSOffload, type,             0, "enum"
        HKR, Ndi\params\*PMNSOffload\enum,              "0", 0, %Disabled%
        HKR, Ndi\params\*PMNSOffload\enum,              "1", 0, %Enabled%
        HKR, Ndi\params\*PMNSOffload,default,,          "1"
        HKR, Ndi\params\*PMNSOffload,optional,,         "0"

        HKR, Ndi\params\*PMWiFiRekeyOffload, ParamDesc, 0, %WiFiRekeyingOffload%
        HKR, Ndi\params\*PMWiFiRekeyOffload, type,      0, "enum"
        HKR, Ndi\params\*PMWiFiRekeyOffload\enum,       "0", 0, %Disabled%
        HKR, Ndi\params\*PMWiFiRekeyOffload\enum,       "1", 0, %Enabled%
        HKR, Ndi\params\*PMWiFiRekeyOffload,default,,   "1"
        HKR, Ndi\params\*PMWiFiRekeyOffload,optional,,  "0"

[cs.std_keywords.reg]
        HKR, Ndi\Params\*PacketCoalescing,  ParamDesc,  0, %PacketCoalescing%
        HKR, Ndi\params\*PacketCoalescing, type,      0, "enum"
        HKR, Ndi\params\*PacketCoalescing\enum,       "0", 0, %Disabled%
        HKR, Ndi\params\*PacketCoalescing\enum,       "1", 0, %Enabled%
        HKR, Ndi\params\*PacketCoalescing,default,,   "1"
        HKR, Ndi\params\*PacketCoalescing,optional,,  "0"
[ac.options.reg]
	HKR,	Ndi\params\Beamforming, ParamDesc,	0,	%BEAMFORMING%
	HKR,	Ndi\params\Beamforming, type,		0,	"enum"
	HKR,	Ndi\params\Beamforming\enum, "0",	0,	%Disabled%
	HKR,	Ndi\params\Beamforming\enum, "1",	0,	%Enabled%
	HKR,	Ndi\params\Beamforming,default,,"1"
[strings]
	BCM1530HM4L_DeviceDesc="DW1530 Wireless-N WLAN Half-Mini Card"
	BCM1540HM4L_DeviceDesc="Dell Wireless 1540 802.11a/g/n (2.4GHz/5GHz)"
	BCM1550HM4L_DeviceDesc="Dell Wireless 1550 802.11ac"
	BCM1560HM4L_DeviceDesc="Dell Wireless 1560 802.11ac"
	BCM1704HMD_DeviceDesc="Dell Wireless 1704 802.11b/g/n (2.4GHz)"
	BCM1708HMD_DeviceDesc="Dell Wireless 1708 802.11b/g/n (2.4GHz)"
	V_BCM="Broadcom"
	BCM43XX_HELP="The Broadcom 802.11 Network Adapter provides wireless local area networking."
	BCM43XX_Service_DispName="Broadcom 802.11 Network Adapter Driver"
	BCM43XX_DiskName="802.11 Network Adapter Install Disk"
	BCM43XXAC_DeviceDesc="Broadcom 802.11ac Network Adapter"
	BCM43XXN_DeviceDesc="Broadcom 802.11n Network Adapter"
	54gAuto="54g - Auto"
	54gPerformance="54g - Performance"
	80211bOnly="802.11b Only"
	AntennaDiversity="Antenna Diversity"
	Auto="Auto"
	AutoShortLong="Auto (Short/Long)"
	BSSPLCPHeader="BSS PLCP Header"
	BlueToothCollaboration="Bluetooth Collaboration"
	Default="Default"
	Disable="Disable"
	Disable80211a="Disable 802.11a"
	Disable80211gb="Disable 802.11g/b"
	DisableBands="Disable Bands"
	Disabled="Disabled"
	Enable="Enable"
	Enabled="Enabled"
	FragmentationThreshold="Fragmentation Threshold"
	LocallyAdministeredMACAddress="Locally Administered MAC Address"
	Long="Long"
	None="None"
	OptimizeBandwidth="Optimize Bandwidth"
	OptimizeDistance="Optimize Distance"
	PLCPHeader="PLCP Header"
	PowerOutput="Power Output"
	PowerSaveMode="Power Save Mode"
	Prefer80211a="Prefer 802.11a"
	Prefer80211gb="Prefer 802.11g/b"
	RTSThreshold="RTS Threshold"
	RadioEnableDisable="Radio Enable/Disable"
	Rate="Rate"
	RoamingDecision="Roaming Decision"
	XPress_Technology="XPress (TM) Technology"
	Location="Location"
	Fast="Fast"
	MinimumPowerConsumption="Minimum Power Consumption"
	BandPreference="Band Preference"
	Aggressive="Aggressive"
	Moderate="Moderate"
	Conservative="Conservative"
	Aux="Aux"
	Main="Main"
	ApCompatibilityMode="AP Compatibility Mode"
	BroaderCompat="Broader Compatibility"
	HigherPerf="Higher Performance"
	WME="WMM"
	Rate_802_11a="Rate (802.11a)"
	Rate_802_11bg="Rate (802.11b/g)"
	WZC_Managed_Ethernet="WZC Managed Ethernet"
	Legacy="Legacy"
	Manage_Wireless_Settings="Manage Wireless Settings"
	DisableRadioUponWiredConnection="Disable Upon Wired Connect"
	SSIDAutoPromote="SSID Autopromote"
	Loose_11h="Loose 11h"
	Strict_11h="Strict 11h"
	MixedCell="Mixed Cell Support"
	vlan_mode="VLAN Priority Support"
	PriorityVLANTag="Priority & VLAN"
	PriorityAndVLANDisabled="Priority & VLAN Disabled"
	PriorityAndVLANEnabled="Priority & VLAN Enabled"
	PriorityEnabled="Priority Enabled"
	VLANEnabled="VLAN Enabled"
	Lock_Wireless_Settings="Lock Wireless Settings"
	Usebestrate="Best Rate"
	NetPattern="Wake Up Frame"
	Intolerant="40MHz Intolerant"
	All="All"
	LossofAP="LossOfLink"
	Mixed_Mode="Mixed Mode"
	LossNet="WakeUpPkt & LinkLoss"
	OBSSCoex="20/40 Coexistence"
	BandwidthCapability="Bandwidth Capability"
	BTAMP="BT-AMP"
	ListenInterval="Assoc Listen Interval"
	D2ListenInterval="D2 Listen Interval"
	WFDChannelNumber="WFD Channel Number"
	EnableLTR="Enable/Disable LTR"
	LTR_ActiveValue="LTR Active value in microseconds"
	WakeOnMagicPacket="Wake On Magic Packet"
	WakeOnPatternMatch="Wake On Pattern Match"
	ARPOffload="ARP Offload"
	NSOffload="NS Offload"
	WiFiRekeyingOffload="WiFi Rekeying Offload"
	PacketCoalescing="Packet Coalescing"
	802_11n_Preamble="802.11n Preamble"
	Short_GI="Short GI"
	BEAMFORMING="BeamForming