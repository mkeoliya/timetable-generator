"Registry">HKLM\Software\Microsoft\Windows NT\CurrentVersion\AppCompatFlags\PenService\1EC353D2-7EE4-4cbe-A63A-4BFE68DBC65A\paneClassDC [DisableFlicksSmoothScrolling]</pattern>
            <pattern type="Registry">HKLM\Software\Microsoft\Windows NT\CurrentVersion\AppCompatFlags\PenService [visio.exe]</pattern>
            <pattern type="Registry">HKLM\Software\Microsoft\Windows NT\CurrentVersion\AppCompatFlags\PenService\36D1B905-CC62-4ab0-9C08-118B66D6DB90\ListBox [DisableFlickFallbackKeys]</pattern>
            <pattern type="Registry">HKLM\Software\Microsoft\Windows NT\CurrentVersion\AppCompatFlags\PenService\36D1B905-CC62-4ab0-9C08-118B66D6DB90\VISIOD [DisableFlickFallbackKeys]</pattern>
            <pattern type="Registry">HKLM\Software\Microsoft\Windows NT\CurrentVersion\AppCompatFlags\PenService\36D1B905-CC62-4ab0-9C08-118B66D6DB90\VISIOG [DisableFlickFallbackKeys]</pattern>
            <pattern type="Registry">HKLM\Software\Microsoft\Windows NT\CurrentVersion\AppCompatFlags\PenService [*]</pattern>
          </objectSet>
        </include>
      </rules>
    </migXml>
    <supportedComponents>
      <supportedComponent>
        <assemblyIdentity name="_" version="1.0.0.0" />
        <supportedComponentIdentity buildType="release" language="neutral" name="Microsoft-Windows-Win32k-Settings" processorArchitecture="*" publicKeyToken="31bf3856ad364e35" settingsVersionRange="0-4" versionScope="nonSxS" xmlns="urn:schemas-microsoft-com:asm.v3" />
        <migXml xmlns="">
          <rules context="System">
            <exclude>
              <objectSet>
                <pattern type="Registry">HKLM\SOFTWARE\Microsoft\Windows NT\CurrentVersion\Windows [AppInit_DLLs]</pattern>
                <pattern type="Registry">HKLM\SOFTWARE\Microsoft\Windows NT\CurrentVersion\Windows [LoadAppInit_DLLs]</pattern>
                <pattern type="Registry">HKLM\SOFTWARE\Microsoft\Windows\CurrentVersion\PrecisionTouchPad\Status\* [*]</pattern>
              </objectSet>
            </exclude>
          </rules>
          <rules context="User">
            <exclude>
              <objectSet>
                <pattern type="Registry">HKCU\Control Panel\Desktop [MouseWheelRouting]</pattern>
              </objectSet>
            </exclude>
          </rules>
        </migXml>
      </supportedComponent>
      <supportedComponent>
        <assemblyIdentity name="_" version="1.0.0.0" />
        <supportedComponentIdentity buildType="release" language="neutral" name="Microsoft-Windows-Win32k-Settings" processorArchitecture="*" publicKeyToken="31bf3856ad364e35" settingsVersionRange="5-7" versionScope="nonSxS" xmlns="urn:schemas-microsoft-com:asm.v3" />
        <migXml xmlns="">
          <rules context="System">
            <exclude>
              <objectSet>
                <pattern type="Registry">HKLM\SOFTWARE\Microsoft\Windows NT\CurrentVersion\Windows [AppInit_DLLs]</pattern>
                <pattern type="Registry">HKLM\SOFTWARE\Microsoft\Windows NT\CurrentVersion\Windows [LoadAppInit_DLLs]</pattern>
                <pattern type="Registry">HKLM\SOFTWARE\Microsoft\Windows\CurrentVersion\PrecisionTouchPad\Status\* [*]</pattern>
              </objectSet>
            </exclude>
          </rules>
        </migXml>
      </supportedComponent>
      <supportedComponent>
        <assemblyIdentity name="_" version="1.0.0.0" />
        <supportedComponentIdentity language="*" name="Microsoft-Windows-Win32k-Settings-DL" processorArchitecture="*" settingsVersionRange="0" xmlns="urn:schemas-microsoft-com:asm.v3" />
      </supportedComponent>
      <supportedComponent>
        <assemblyIdentity name="_" version="1.0.0.0" />
        <supportedComponentIdentity language="*" name="Microsoft-Windows-TabletPC-UIHub" processorArchitecture="*" settingsVersionRange="0" xmlns="urn:schemas-microsoft-com:asm.v3" />
        <migXml xmlns="">
          <rules context="User">
            <detects>
              <detect>
                <condition>MigXmlHelper.DoesStringContentEqual("Registry", "HKCU\Softw