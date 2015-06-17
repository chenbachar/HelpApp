#this model represents a user in our system

from google.appengine.api import users
from google.appengine.ext import ndb
from datetime import datetime
from datetime import timedelta

class User(ndb.Model):
	email = ndb.StringProperty()
	name = ndb.StringProperty()
	status = ndb.BooleanProperty()
	hasCar = ndb.BooleanProperty()
	lastSeen = ndb.DateTimeProperty()
	
	@staticmethod
	def checkUser():
		googleUser = users.get_current_user()
		if not googleUser:
			return False
		
		user = User.query(User.email == googleUser.email()).get()
		if user:
			user.lastSeen = datetime.utcnow()
			user.put()
			return user
		
		return False
	
	#generates a url at which the user can login, and then will be redirected back to volunteer location
	@staticmethod
	def loginUrl():
		return users.create_login_url('/volunteer')
	
	#generates a url at which the user can logout, and then will be redirected back to the index location
	@staticmethod
	def logoutUrl():
		return users.create_logout_url('/')
	
	@staticmethod
	def connect():
		googleUser = users.get_current_user()
		if googleUser:
			user = User.query(User.email == googleUser.email()).get()
			if not user:	#add user to DB
				user = User()
				user.email = googleUser.email()
				user.status = False
				user.hasCar = False
				user.name = "None"
				user.put()
			return user 	#user exists

		else:
			return None
	
	
	@classmethod
	def updateInfo(self,uEmail,updName,updCar):
		googleUser = users.get_current_user()
		googleEmail = googleUser.email()
		if googleEmail != uEmail:
			return False
		user = User.query(User.email == uEmail).get()
		if user:
			user.name = updName
			user.hasCar = updCar
			user.put()
			return True
		else:
			return False
			
	@classmethod
	def setStatus(self,uEmail,stat):
		googleUser = users.get_current_user()
		googleEmail = googleUser.email()
		if googleEmail != uEmail:
			return False
		user = User.query(User.email == uEmail).get()
		if user:
			user.status = stat
			user.put()
			return True
		else:
			return False

			
	@classmethod
	def getLastSeen(self,uEmail):
		googleUser = users.get_current_user()
		googleEmail = googleUser.email()
		if googleEmail != uEmail:
			return False
		user = User.query(User.email == uEmail).get()
		if user:
			return user.lastSeen
		else:
			return False