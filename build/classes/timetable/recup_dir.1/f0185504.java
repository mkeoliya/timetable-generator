rolSet\Control\Ataport\* [*]</pattern>
                  <pattern type="Registry">HKLM\SYSTEM\CurrentControlSet\Services\MSAHCI\Controller0\* [*]</pattern>
                  <pattern type="Registry">HKLM\SYSTEM\CurrentControlSet\Services\Disk\ [TimeOutValue]</pattern>
                  <pattern type="Registry">HKLM\SYSTEM\CurrentControlSet\Services\Cdrom\ [TimeOutValue]</pattern>
                  <pattern type="Registry">HKLM\SYSTEM\CurrentControlSet\Services\Storahci\Parameters\* [*]</pattern>
                </objectSet>
              </merge>
            </rules>
          </migXml>
        </machineSpecific>
      </supportedComponent>
    </supportedComponents>
    <machineSpecific>
      <migXml xmlns="">
        <plugin classId="{A3767BB7-1E7E-42d2-A0B9-18537BACADD7}" file="%windir%\system32\migration\StorMigPlugin.dll" />
        <rules context="System">
          <include>
            <objectSet>
              <pattern type="Registry">HKLM\SYSTEM\CurrentControlSet\Control\ScsiPort\* [*]</pattern>
              <pattern type="Registry">HKLM\SYSTEM\CurrentControlSet\Control\StorPort\* [*]</pattern>
              <pattern type="Registry">HKLM\SOFTWARE\Microsoft\Windows NT\CurrentVersion\iSCSI\* [*]</pattern>
              <pattern type="Registry">HKLM\SYSTEM\CurrentControlSet\Control\WMI\Security [7A2C6C2B-E5A5-49ad-AD68-133089ACD74D]</pattern>
              <pattern type="Registry">HKLM\SYSTEM\CurrentControlSet\Control\WMI\Security [C75258E9-BE79-4a48-A23D-EEB6F8FB940C]</pattern>
              <pattern type="Registry">HKLM\SYSTEM\CurrentControlSet\Control\WMI\Security [53EF8D5F-36F3-4124-8B76-C6AD521A1021]</pattern>
              <pattern type="Registry">HKLM\SYSTEM\CurrentControlSet\Control\WMI\Security [45755098-4291-43df-9720-B58642DD63DF]</pattern>
              <pattern type="Registry">HKLM\SYSTEM\CurrentControlSet\Control\WMI\Security [225B9D64-47A9-41c8-81CD-69BC02652D87]</pattern>
              <pattern type="Registry">HKLM\SYSTEM\CurrentControlSet\Control\WMI\Security [8EAEF9D8-C053-49d3-9205-65C703C2ECC1]</pattern>
              <pattern type="Registry">HKLM\SYSTEM\CurrentControlSet\Control\WMI\Security [556BC0B0-0FB5-40f2-9255-B7D9A669DAEC]</pattern>
              <pattern type="Registry">HKLM\SYSTEM\CurrentControlSet\Control\WMI\Security [B35694DE-D323-49d2-ABB2-8139209AD150]</pattern>
              <pattern type="Registry">HKLM\SYSTEM\CurrentControlSet\Control\WMI\Security [EA4D82BF-29DA-4e12-800A-E5437964462C]</pattern>
              <pattern type="Registry">HKLM\SYSTEM\CurrentControlSet\Control\WMI\Security [420512D9-0537-4c67-A779-84BA7B29CE9F]</pattern>
              <pattern type="Registry">HKLM\SYSTEM\CurrentControlSet\Control\WMI\Security [41646815-7524-4bc0-904A-CD7D510EAC02]</pattern>
              <pattern type="Registry">HKLM\SYSTEM\CurrentControlSet\Control\WMI\Security [391F3325-0BA3-4083-A861-CF4F6F97A527]</pattern>
              <pattern type="Registry">HKLM\SYSTEM\CurrentControlSet\Control\WMI\Security [46B122C0-3767-4069-916E-3A43702F05CE]</pattern>
              <pattern type="Registry">HKLM\SYSTEM\CurrentControlSet\Control\WMI\Security [7BB02370-B8AE-4d29-88DE-76951D3245BA]</pattern>
              <pattern type="Registry">HKLM\SYSTEM\CurrentControlSet\Control\WMI\Security [58515BF3-2F59-4f37-B74F-85AEEC652AD6]</pattern>
              <pattern type="Registry">HKLM\SYSTEM\CurrentControlSet\Control\WMI\Security [84CA6FD6-B152-4e6a-8869-FDE5E37B6157]</pattern>
              <pattern type="Registry">HKLM\SYSTEM\CurrentControlSet\Control\WMI\Security [D7931411-0376-4869-A491-8D679BFC004A]</pattern>
              <pattern type="Registry">HKLM\SYSTEM\CurrentControlSet\Control\WMI\Security [36B58EA2-C461-4bb0-AC8E-952F59D251ED]</pattern>
              <pattern type="Registry">HKLM\SYSTEM\CurrentControlSet\Control\WMI\Security [B4D1C606-8682-4b7a-AC6B-D883D91555FB]</pattern>
              <pattern type="Registry">HKLM\SYSTEM\CurrentControlSet\Control\WMI\Security [4AE27CD9-8DFA-4c37-A42C-B88A93E3E521]</pattern>
              <pattern type="Registry">H