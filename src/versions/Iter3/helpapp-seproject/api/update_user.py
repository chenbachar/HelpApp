import webapp2
import json
from models.user import User

class UpdateUserHandler(webapp2.RequestHandler):
	def get(self):
		user = User.checkUser()
		if not user:
			return
		
		update_name = self.request.get('name')
		update_car = self.request.get('car')
		needCar = False
		if update_car == 'true':
			needCar = True
		if update_name and update_car:
			update = User.updateInfo(user.email,update_name,needCar)        
			self.response.write(json.dumps({'status':'ok'}))
		else:
			self.response.write(json.dumps({'status':'error'}))
			
app = webapp2.WSGIApplication([
	('/update_user', UpdateUserHandler)
], debug=True)