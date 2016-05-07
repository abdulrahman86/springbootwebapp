function Hello($scope, $http) {

    $scope.model = {};

    $scope.getCityById = function() {
            $http.get('http://localhost:8080/cities/' + $scope.model.city).
                success(function(data) {
                    $scope.cityById = data;
                });

    }

    $scope.createCityById = function() {
            $http.post('http://localhost:8080/cities', $scope.model.cityCreate).
                success(function(data) {
                    $scope.refresh();
                });

    }

    $scope.updateCityById = function() {
            $http.put('http://localhost:8080/cities', $scope.model.cityUpdate).
                success(function(data) {
                    $scope.refresh();
                });
    }

    $scope.deleteCityById = function() {
        $http.delete('http://localhost:8080/cities/' + $scope.model.city).
            success(function(data) {
                $scope.refresh();
            });
    }

    $scope.refresh = function() {
        $http.get('http://localhost:8080/cities').
            success(function(data) {
                $scope.cityById = {};
                $scope.cities = data;
            });
    }

    $scope.calculateDistance = function() {
        $http.get('http://localhost:8080/cities/' + $scope.model.city1).
            then(function(data) {
                $http.get('http://localhost:8080/cities/' + $scope.model.city2).then(function(data1){
                    $scope.distance = data1.latitude;
                });
            });
    }

    $scope.refresh();
}