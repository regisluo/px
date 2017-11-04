var myng = angular.module('myng', ['ngRoute', 'ngResource']);

myng.config(function ($routeProvider, $locationProvider) {
    $routeProvider
        .when('/page1', {
            templateUrl: 'src/static/page1.html',
            controller: 'page1.ctrl'
        })
        .when('/page2/:para1', {
            templateUrl: 'src/static/page2.html',
            controller: 'page2.ctrl'
        })
        .when('/expression', {
            templateUrl: 'src/static/expression.html',
            controller: 'expression.ctrl'
        })
        .when('/directive', {
            templateUrl: 'src/static/directives.html',
            controller: 'directives.ctrl'
        })
        .when('/filters', {
            templateUrl: 'src/static/filter.html',
            controller: 'filter.ctrl'
        })
        .when('/student-edit', {
            templateUrl: 'src/static/student_add.html',
            controller: 'student.ctrl'
        })
        .when('/student-list', {
            templateUrl: 'src/static/student_list.html',
            controller: 'student.ctrl'
        })
        .when('/tutor-list', {
            templateUrl: 'src/static/tutor-list.html',
            controller: 'tutor.controller'
        })
        .when('/tutor-edit', {
            templateUrl: 'src/static/tutor-edit.html',
            controller: 'tutor.controller'
        })
        .otherwise({
            redirectTo: '/'
        });

    $locationProvider.hashPrefix('');
});

myng.controller('expression.ctrl', function ($scope) {
    $scope.msg = 'msg';
    $scope.student = { name: 'Jim', age: 20 };
    $scope.tranNum = function (num) {
        if (num == 1) {
            return 'one';
        } else if (num == 2) {
            return 'two';
        } else {
            return 'not support';
        }

    }

    $scope.alertme = function () {
        alert('haha');
    }

});

myng.controller('page1.ctrl', function ($scope) {
    $scope.hello = 'hello page 1';
});

myng.controller('page2.ctrl', function ($scope, $routeParams) {
    $scope.id = $routeParams.para1;
});

myng.controller('directives.ctrl', function ($scope) {
    $scope.init = function () {
        $scope.init = 'xyz';
    }

    $scope.books = ['java', 'python', 'css'];

    $scope.showMsg = function (myinput) {
        $scope.msg = myinput;
    }

});

myng.controller('filter.ctrl', function ($scope) {
    $scope.student = { name: 'Jim', age: 20 };
    $scope.show = function () {
        $scope.dup = 'duplicate name';
    }
});

var url = "/";

myng.factory('StudentService',function($resource){
    return $resource(url+'students/:id',null,{
        addStu:{method:'POST'},
        getOne:{method:'GET',params:{id:'@id'}},
        update:{method:'PUT'},
        myDelete:{method:'DELETE',params:{id:'@id'}}
    });
});

myng.controller('student.ctrl', function ($scope, $http,$location,StudentService,$route,$routeParams) {

    $scope.initStu = function(){
        var id = $routeParams.id;
        if(id){
            StudentService.get({id:id},
                function(success){
                    populateInterests(success);
                    success.birthday = moment(success.birthday).toDate();
                    $scope.student = success;
            },function(error){
                console.log('Cannot get student with id: ' + id);
            });
        }
    }

    $scope.update = function(valid){
        if(valid){
            console.log('update student with ngResource...');
            if ($scope.student.interests) {
                var ints = [];
                if ($scope.student.interests.reading) ints.push("reading");
                if ($scope.student.interests.swimming) ints.push("swimming");
                if ($scope.student.interests.climbing) ints.push("climbing");
                $scope.student.interests = ints;
            }
            StudentService.update($scope.student,function(success){
                console.log('success updated');
                $location.path('/student-list');
            },function(error){
                console.log('fail updated');
            });
        }
    }

    $scope.delete = function(id){
        if(confirm('Are you sure to delete student: ' + id)){
            StudentService.myDelete({id:id},function(sucess){
                $route.reload();
            },function(error){
                console.log('error delete');
            });

        }
    }

    $scope.getAllStudentsWithngResource = function(){
        console.log('get all students with ngResource...');
        $scope.students = StudentService.query();
    }

    $scope.saveWithNgResoure = function(valid){
        if(valid){
            console.log('saving student with ngResource...');
            if ($scope.student.interests) {
                var ints = [];
                if ($scope.student.interests.reading) ints.push("reading");
                if ($scope.student.interests.swimming) ints.push("swimming");
                if ($scope.student.interests.climbing) ints.push("climbing");
                $scope.student.interests = ints;
            }
            StudentService.addStu($scope.student,function(success){
                console.log('success added');
                $location.path('/student-list');
            },function(error){
                console.log('fail added');
            });
        }
    }

   
    $scope.save = function (valid) {
        var url = '/students';
        if(valid){
            console.log('saving student...');
            
                    if ($scope.student.interests) {
                        var ints = [];
                        if ($scope.student.interests.reading) ints.push("reading");
                        if ($scope.student.interests.swimming) ints.push("swimming");
                        if ($scope.student.interests.climbing) ints.push("climbing");
                        $scope.student.interests = ints;
                    }
            
                    $http.post(url, $scope.student).then(function (success) {
                        console.log('student add success');
                        $location.path('/student-list');
                    }, function (error) {
                        console.log('student add error');
                    });
        }else{
            alert('error');
            console.log('add student form inputs error');
        }
       
    }

    $scope.getAllStudents = function () {
        $http.get(url).then(function (success) {
            console.log('response: ' + success);
            $scope.students = success.data;
        }, function (error) {
        });
    }


});

myng.filter('interestFilter', function () {
    return function (ints) {
        var show = '';
        for (i = 0; i < ints.length; i++) {
            show += ' ' + ints[i];
        }
        return show;
    }
});

function populateInterests(student) {
    if (student.interests) {
        student.interests.forEach(function (item) {
            if (item == "reading") {
                student.interests.reading = true;
            }
            if (item == "swimming") {
                student.interests.swimming = true;
            }
            if (item == "climbing") {
                student.interests.climbing = true;
            }

        }, this);
    }
};