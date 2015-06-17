#this model represents a request in our system
from google.appengine.ext import ndb
from datetime import datetime
from datetime import timedelta

class Request(ndb.Model):
	city = ndb.StringProperty()
	phone = ndb.StringProperty()
	date = ndb.DateTimeProperty()
	description = ndb.StringProperty()
	isCarNeeded = ndb.BooleanProperty()
	
	@classmethod
	def add(self,cit,phoneNum,desc,carNeeded):
		req = Request()
		req.city = cit
		req.phone = phoneNum
		req.description = desc
		req.isCarNeeded = carNeeded
		req.date = datetime.utcnow()
		req.put()
		#converting UTC to GMT+2[Israel timezone] 
		#utc = datetime.utcnow()
		#UTC_OFFSET = 3 
		#req.date = utc# - timedelta(hours=UTC_OFFSET) #(UTC+3 = GMT+2)
	
	@classmethod
	def getMostRecent(self):
		qry = Request.query(Request.date < datetime.utcnow())
		return qry
		
		