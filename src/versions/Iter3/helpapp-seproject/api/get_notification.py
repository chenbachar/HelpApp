import webapp2
import json
from models.user import User
from models.request import Request
class getNotificationHandler(webapp2.RequestHandler):
	def get(self):
		user = User.checkUser()
		if not user:
			return
			
		if user:
			lastSeen = User.getLastSeen(user.email)
			#recent = Request.getMostRecent(lastSeen)
			notification = "False"
			#if lastSeen < recent:
			#	notification = "True"
			self.response.write(json.dumps({'status':notification}))

app = webapp2.WSGIApplication([
	('/get_notification', getNotificationHandler)
], debug=True)