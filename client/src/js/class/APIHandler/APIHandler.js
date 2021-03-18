import { testFunctionOne } from "../../module/ANewModule/ANewModule";

/**
 * An example of how to implement classes with modules
 */
class APIHandler {
    constructor() {
        return true;
    }

    getStuff() {
        console.log("getting stuff from API or something idk");
        testFunctionOne();
    }
}

module.exports = APIHandler;