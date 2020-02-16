738428-1654721687-432734479-3232135806-4053264122-3456934681)" operationHint="replace" />
          <securityDescriptorDefinition name="WRP_FILE_DEFAULT_SDDL" sddl="O:S-1-5-80-956008885-3418522649-1831038044-1853292631-2271478464G:S-1-5-80-956008885-3418522649-1831038044-1853292631-2271478464D:P(A;;FA;;;S-1-5-80-956008885-3418522649-1831038044-1853292631-2271478464)(A;;GRGX;;;BA)(A;;GRGX;;;SY)(A;;GRGX;;;BU)(A;;GRGX;;;S-1-15-2-1)(A;;GRGX;;;S-1-15-2-2)S:(AU;FASA;0x000D0116;;;WD)" operationHint="replace" description="Default SDDL for Windows Resource Protected file" />
        </securityDescriptorDefinitions>
      </accessControl>
    </security>
  </trustInfo>
  <migration settingsVersion="1">
    <migXml xmlns="">
      <plugin classId="{401F8281-A9B6-49F9-9F71-8AEA167EEEFD}" file="%windir%\system32\migration\WMIMigrationPlugin.dll" />
      <rules context="system">
        <include>
          <objectSet>
            <pattern type="File">%windir%\system32\wbem\* [*]</pattern>
            <pattern type="File">%windir%\sysWow64\wbem\* [*]</pattern>
            <pattern type="Registry">HKLM\Software\Microsoft\WBEM\CIMOM [Autorecover MOFs]</pattern>
            <pattern type="Registry">HKLM\Software\Microsoft\WBEM\CIMOM\SecuredHostProviders [*]</pattern>
            <pattern type="Registry">HKLM\Software\Microsoft\WBEM\CIMOM\CompatibleHostProviders [*]</pattern>
            <pattern type="Registry">HKLM\Software\Microsoft\WBEM\CIMOM [DefaultSecuredHost]</pattern>
            <pattern type="Registry">HKLM\Software\Microsoft\WBEM\CIMOM [AutoRestoreEnabled]</pattern>
            <pattern type="Registry">HKLM\Software\Wow6432Node\Microsoft\WBEM\CIMOM\SecuredHostProviders [*]</pattern>
            <pattern type="Registry">HKLM\Software\Wow6432Node\Microsoft\WBEM\CIMOM\CompatibleHostProviders [*]</pattern>
            <pattern type="Registry">HKLM\Software\Wow6432Node\Microsoft\WBEM\CIMOM [DefaultSecuredHost]</pattern>
          </objectSet>
        </include>
        <exclude>
          <objectSet>
            <pattern type="File">%windir%\system32\wbem\AutoRecover\* [*]</pattern>
            <pattern type="File">%windir%\system32\wbem\logs [*]</pattern>
            <pattern type="File">%windir%\system32\wbem\Repository [*]</pattern>
            <pattern type="File">%windir%\system32\wbem\xml [*]</pattern>
            <pattern type="File">%windir%\sysWow64\wbem\AutoRecover\* [*]</pattern>
            <pattern type="File">%windir%\sysWow64\wbem\logs [*]</pattern>
            <pattern type="File">%windir%\sysWow64\wbem\Repository [*]</pattern>
            <pattern type="File">%windir%\sysWow64\wbem\xml [*]</pattern>
          </objectSet>
        </exclude>
        <locationModify script="MigXmlHelper.RelativeMove('HKLM\Software\Microsoft\WBEM\CIMOM','HKLM\Software\Microsoft\WBEM\CIMOM_Migrated')">
          <objectSet>
            <pattern type="Registry">HKLM\Software\Microsoft\WBEM\CIMOM [Autorecover MOFs]</pattern>
          </objectSet>
        </locationModify>
      </rules>
    </migXml>
    <supportedComponents>
      <supportedComponent>
        <assemblyIdentity name="_" version="1.0.0.0" />
        <supportedComponentIdentity buildType="release" language="neutral" name="Microsoft-Windows-WMI-Core" processorArchitecture="wow64" publicKeyToken="31bf3856ad364e35" settingsVersionRange="0-1" versionScope="nonSxS" xmlns="urn:schemas-microsoft-com:asm.v3" />
        <migXml xmlns="">
          <rules context="system">
            <locationModify script="MigXmlHelper.RelativeMove('HKLM\Software\Microsoft\WBEM\CIMOM','HKLM\Software\Microsoft\WBEM\CIMOM_Migrated')">
              <objectSet>
                <pattern type="Registry">HKLM\Software\Microsoft\WBEM\CIMOM [Autorecover MOFs]</pattern>
              </objectSet>
            </locationModify>
          </rules>
        </migXml>
      </supportedComponent>
      <supportedComponent>
        <assemblyIdentity name="_" version="1.0.0.0" />
        <supportedComponentIdentity language="*" name="Microsoft-Windows-WMI-