actionApp.controller('View1Controller', ['$rootScope', '$scope', '$http', 
function($rootScope, $scope, $http) {
    $scope.$on('$viewContentLoaded', function() {
        console.log('Page is loaded.');
    });
    
    $scope.search = function() {
        personName = $scope.personName;
        $http.get('search', {
            params : { personName:personName }
        }).then(function(response) {
            $scope.person = response.data;
            console.log($scope.person.age);
        }, function(error) {
            console.log(error);
        });
    };
}])
;

actionApp.controller('View2Controller', ['$rootScope', '$scope', 
function($rootScope, $scope) {
    $scope.$on('$viewContentLoaded', function() {
        console.log('Page is loaded.')
    });
}]);
