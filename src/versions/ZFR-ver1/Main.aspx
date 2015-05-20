<%@ Page Title="" Language="C#" MasterPageFile="~/MasterPage.master" AutoEventWireup="true" CodeFile="Main.aspx.cs" Inherits="Main" %>

<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="Server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" runat="Server">
    <asp:ImageButton ID="volunteer" runat="server" Height="80px" ImageUrl="~/Resources/Pics/volunteer-button.PNG" Width="50%" PostBackUrl="~/Volunteer.aspx" />
    <p />
    <asp:ImageButton ID="helpwanted" runat="server" Height="80px" ImageUrl="~/Resources/Pics/help-wanted-button.PNG" Width="50%" PostBackUrl="~/HelpSeeker.aspx" />
</asp:Content>

