import webapp2
import json
from models.user import User
from models.request import Request

class getRequestHandler(webapp2.RequestHandler):
	def get(self):
		user = User.checkUser()
		if not user:
			return

		status = 'ok'
		req = Request.getRequest(user.city)
		if not req:
			status = 'error'

		self.response.write(json.dumps({'status':status, 'request':req }))
app = webapp2.WSGIApplication([
	('/get_requests', getRequestHandler)
], debug=True)