
describe('the function checkBoxToQueryString()', function () {

    it('should return a query when the box is checked', function () {
       var ownerCheckbox = {
           checked: true,
           id: "owner",
           nextElementSibling: {
               value: "Bob"
           }
       };
       expect(checkBoxToQueryString(ownerCheckbox)).toBe("&owner=Bob");
    });

    it('should return an empty string when the box is not checked', function () {
        var statusCheckbox = {
            checked: false,
            value: "status",
            nextElementSibling: {
                value: "complete"
            }
        };
        expect(checkBoxToQueryString(statusCheckbox)).toBe("");
    });


});