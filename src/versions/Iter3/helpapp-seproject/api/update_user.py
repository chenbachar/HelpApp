import webapp2
import json
from models.user import User

class UpdateUserHandler(webapp2.RequestHandler):
	def get(self):
		user = User.checkUser()
		if not user:
			return
		
		update_name = self.request.get('name')
		update_phone = self.request.get('phone')
		try:
			update_phone = int(update_phone)
			break
		except ValueError:
			print "Phone not ok" //???
		
		update_car = self.request.get('car')
		needCar = False
		if update_car == 'true':
			needCar = True
		if update_phone and update_phone and update_car:
			update = User.updateInfo(user.email,update_name,update_phone,needCar)        
			self.response.write(json.dumps({'status':'ok'}))
		else:
			self.response.write(json.dumps({'status':'error'}))
app = webapp2.WSGIApplication([
	('/update_user', UpdateUserHandler)
], debug=True)