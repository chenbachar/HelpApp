<%@ Page Language="C#" AutoEventWireup="true" CodeFile="VolunteerRegistration.aspx.cs" Inherits="Volunteer" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <div id="main" style="border-style: solid; border-width: thick; margin-left: auto; margin-right: auto; background-color: aqua; width: 60%; margin-top: 5%; direction: rtl">
            <asp:Label ID="Label1" runat="server" Text="מתנדב חדש:" Font-Bold="True" Font-Names="Arial" Font-Size="XX-Large" Font-Underline="True"></asp:Label>
            <table style="width: 50%;">
                <tr>
                    <td style="font-family: Arial, Helvetica, sans-serif; font-size: x-large; width: 30%;">שם משתמש:</td>
                    <td>
                        <asp:TextBox ID="TextBox1" runat="server"></asp:TextBox>
                    </td>
                </tr>
                <tr>
                    <td style="width: 30%; font-family: Arial, Helvetica, sans-serif; font-size: x-large;">סיסמא:</td>
                    <td>
                        <asp:TextBox ID="TextBox2" runat="server" TextMode="Password"></asp:TextBox>
                    </td>
                </tr>
                <tr>
                    <td style="width: 30%; font-family: Arial, Helvetica, sans-serif; font-size: x-large;">אזור זמינות:</td>
                    <td>
                        <asp:TextBox ID="TextBox3" runat="server"></asp:TextBox>
                    </td>
                </tr>
                <tr>
                    <td style="width: 30%; font-family: Arial, Helvetica, sans-serif; font-size: x-large;">אפשרויות:</td>
                    <td>
                        <asp:CheckBoxList ID="CheckBoxList1" runat="server" Font-Names="Arial">
                            <asp:ListItem>בעל רכב</asp:ListItem>
                        </asp:CheckBoxList>
                    </td>
                </tr>
                <tr>
                    <td style="width: 30%; font-family: Arial, Helvetica, sans-serif; font-size: x-large;">שפה:</td>
                    <td>
                        <asp:CheckBoxList ID="CheckBoxList2" runat="server" Font-Names="Arial">
                            <asp:ListItem>עברית</asp:ListItem>
                            <asp:ListItem>אנגלית</asp:ListItem>
                            <asp:ListItem>רוסית</asp:ListItem>
                            <asp:ListItem>ערבית</asp:ListItem>
                            <asp:ListItem>צרפתית</asp:ListItem>
                        </asp:CheckBoxList>
                    </td>
                </tr>
                <tr>
                    <td style="width: 30%; font-family: Arial, Helvetica, sans-serif; font-size: x-large;">פרטים נוספים:</td>
                    <td>
                        <asp:TextBox ID="TextBox6" runat="server" TextMode="MultiLine" style="resize:none; width: 50%; height: 100%"></asp:TextBox>
                    </td>
                </tr>
                <tr>
                    <td style="width: 20%;">
                        <asp:Button ID="Button1" runat="server" BackColor="White" BorderStyle="Solid" Text="הירשם" Font-Size="Medium" Height="41px" Width="61%" />
                        <br />
                    </td>
                    <td>
                       
                    </td>
                </tr>
            </table>
        </div>
    </form>
</body>
</html>
