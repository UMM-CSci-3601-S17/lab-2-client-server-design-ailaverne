// Just some example testing.

var testStringLength = function(str) {
    return str.length
}

var returnKittens = function() {
    return "kittens"
}

describe('testing basic functions', function(){
    it('should return the correct string length', function(){
        expect(testStringLength("kittens")).toEqual(7);
    });

    it('returnKittens should return kittens', function(){
        expect(returnKittens()).toBe("kittens");
    });

});
