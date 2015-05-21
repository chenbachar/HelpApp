<%@ Page Title="" Language="C#" MasterPageFile="~/masterPage.Master" AutoEventWireup="true" CodeBehind="homePage.aspx.cs" Inherits="helpApp.homePage1" %>
<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
</asp:Content>



<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">

          <table class="auto-style1" style="width: 100%; height: 99%;">
        <tr style="height: 48%;">
            <td style="background-color: #00B0F0; text-align: center;">
                <asp:Button ID="inNeedButton" runat="server" BackColor="#F2F2F2" Font-Bold="True" Font-Size="300%" ForeColor="#00B0F0" Height="70%" Text="מסתייע" Width="50%" />
            </td>
        </tr>
        <tr style="height: 4%;">
            <td>&nbsp;</td>
        </tr>
        <tr style="height: 48%;">
            <td style="background-color: #F2F2F2; text-align: center;">
                <asp:Button ID="volunteerButton" runat="server" BackColor="#00B0F0" Font-Bold="True" Font-Size="300%" ForeColor="#F2F2F2" Height="70%" Text="מתנדב" Width="50%" />
            </td>
        </tr>
        </table>

</asp:Content>
