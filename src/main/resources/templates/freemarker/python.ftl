from locust import HttpLocust, TaskSet, task
class WebsiteTasks(TaskSet):
    def on_start(self):
        self.client.post("/login", {
            "username": "test",
            "password": "123456"
        })

    @task
    def index(self):
        self.client.get("/")

    @task
    def about(self):
        self.client.get("/about/")

class WebsiteUser(HttpLocust):
    task_set = WebsiteTasks
    host = "http://www.baidu.com"
    min_wait = 1000
    max_wait = 5000