using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace helpApp
{
    public class Volunteer
    {
        private string username, firstName, lastName, language, mail;
        private int phone;
        private Boolean status;


        public Volunteer(string username, string firstName, string lastName, int phone, string language, Boolean status, string mail)
        {
            this.username = username;
            this.firstName = firstName;
            this.lastName = lastName;
            this.phone = phone;
            this.language = language;
            this.status = status;
            this.mail = mail;
        }

        public string Username
        {
            set { this.username = value; }
            get { return this.username; }
        }
        public string FirstName
        {
            set { this.firstName = value; }
            get { return this.firstName; }
        }
        public string LastName
        {
            set { this.lastName = value; }
            get { return this.lastName; }
        }
        public string Language
        {
            set { this.language = value; }
            get { return this.language; }
        }
        public Boolean Status
        {
            set { this.status = value; }
            get { return this.status; }
        }
        public int Phone
        {
            set { this.phone = value; }
            get { return this.phone; }
        }
        public string Mail
        {
            set { this.mail = value; }
            get { return this.mail; }
        }
    }
}