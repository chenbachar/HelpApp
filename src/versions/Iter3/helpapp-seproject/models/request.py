#this model represents a request in our system
from google.appengine.ext import ndb
from datetime import datetime
from datetime import timedelta

class Request(ndb.Model):
	city = ndb.IntegerProperty()
	phone = ndb.StringProperty()
	date = ndb.DateTimeProperty()
	description = ndb.StringProperty()
	isCarNeeded = ndb.BooleanProperty()
	
	@staticmethod
	def add(cit,phoneNum,desc,carNeeded):
		req = Request()
		req.city = cit
		req.phone = phoneNum
		req.description = desc
		req.isCarNeeded = carNeeded
		req.date = datetime.utcnow()
		req.put()
		
	@staticmethod
	def getRequest(cit,car):
		qry = None
		#if cit == 1:
		#	qry = Request.query( Request.city >= 1, Request.city <= 11 ).fetch()
		#else:
		qry = Request.query( Request.city == cit ).fetch()
		req = []
		for request in qry:
			req.append({
				"phone": request.phone,
				"description": request.description,
				"city": request.city,
				"isCarNeeded": request.isCarNeeded
			})
		return req
		
	#@classmethod
	#def getMostRecent(self):
	#	day = Request.date.day()
	#	qry = Request.query(day < datetime.utcnow().day).get()
	#	return qry
	#	
		