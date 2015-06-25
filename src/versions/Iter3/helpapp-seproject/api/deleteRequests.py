import webapp2
from models.request import Request

class deleteRequestsHandler(webapp2.RequestHandler):
	def get(self):
		Request.deleteRequest()    
		
app = webapp2.WSGIApplication([
	('/tasks/deleteRequests', deleteRequestsHandler)
], debug=True)