import random
from locust import HttpLocust, TaskSet, task

class TestTasks(TaskSet):
<#if start??>
    def on_start(self):
    <#list start as s>
        <#if s.method == 'GET'>
        self.client.get("${s.uri}")
        <#elseif s.method == 'POST'>
        self.client.post("${s.uri}",${s.params})
        </#if>
    </#list>
</#if>
<#list requests! as r>

    <#if r.weight == 0>
    @task
    <#else >
    @task(${r.weight})
    </#if>
    def ${r.name}(self):
    <#if r.method == 'GET'>
        self.client.get("${r.uri}")
    <#elseif r.method == 'POST'>
        <#if r.paramsSize == 0>
        self.client.post("${r.uri}",{})
        <#elseif r.paramsSize == 1>
        self.client.post("${r.uri}",${r.paramsFirst})
        <#else>
        args = ${r.params}
        self.client.post("${r.uri}",args[random.randint(0,length-1)])
        </#if>
    </#if>
</#list>

class DoTest(HttpLocust):
    task_set = TestTasks
    host = "<#if domain?lower_case?index_of("http") == 0>${domain}<#else>http://${domain}</#if>"
    min_wait = ${minWait?c}
    max_wait = ${maxWait?c}