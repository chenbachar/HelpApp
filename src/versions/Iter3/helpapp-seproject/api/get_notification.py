import webapp2
import json
from models.user import User
from models.request import Request
class getNotificationHandler(webapp2.RequestHandler):
	def get(self):
		user = User.checkConnected()
		
		if not user:
			self.response.write('You are not connected')
			return
			
		if user.status == False:
			self.response.write(json.dumps({'status':'False'}))
			return
		
		if user.status == True: 
			recent = Request.checkRecent(user.lastSeen)
			if recent == False: 
				self.response.write(json.dumps({'status':'False'}))
				return
			if recent == True:
				cit = Request.checkCity(user.city)
				if cit == False:
					self.response.write(json.dumps({'status':'False'}))
					return
				if cit == True:
					self.response.write(json.dumps({'status':'True'}))
					return
		self.response.write(json.dumps({'status':'False'}))
		
app = webapp2.WSGIApplication([
	('/get_notification', getNotificationHandler)
], debug=True)