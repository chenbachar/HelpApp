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
	def getRequest(cit):
		qry = None
		if cit == 100:
			qry = Request.query( Request.city >= 0 ).fetch()
		elif cit == 1:
			qry = Request.query( Request.city >= 1, Request.city <= 11 ).fetch()
		elif cit == 12:
			qry = Request.query( Request.city >= 12, Request.city <= 19 ).fetch()
		elif cit == 20:
			qry = Request.query( Request.city >= 20, Request.city <= 26 ).fetch()
		elif cit == 27:
			qry = Request.query( Request.city >= 27, Request.city <= 39 ).fetch()
		elif cit == 40:
			qry = Request.query( Request.city >= 40, Request.city <= 44 ).fetch()
		elif cit == 45:
			qry = Request.query( Request.city >= 45, Request.city <= 50 ).fetch()
		elif cit == 51:
			qry = Request.query( Request.city >= 51, Request.city <= 56 ).fetch()
		elif cit == 57:
			qry = Request.query( Request.city >= 57, Request.city <= 62 ).fetch()
		else:
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
	
	
	#qry = Request.query( Request.city == cit ).get() --> returns most recent value
	#@classmethod
	#def getMostRecent(self):
	#	day = Request.date.day()
	#	qry = Request.query(day < datetime.utcnow().day).get()
	#	return qry
	#	
		