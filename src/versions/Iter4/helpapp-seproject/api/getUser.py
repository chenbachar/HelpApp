import webapp2
import json
from models.user import User
from models.request import Request

class getUserHandler(webapp2.RequestHandler):
	def get(self):
		user = User.checkUser()
		if not user:
			self.response.write("None")
			return

		self.response.write(user.email)
app = webapp2.WSGIApplication([
	('/getUser', getUserHandler)
], debug=True)