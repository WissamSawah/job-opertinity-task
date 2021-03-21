import http from "../http-common";

class BookingResourceService {
  getAll() {
    return http.get("/resource");
  }

  getAllBooking() {
    return http.get("/booking");
  }

  create(data) {
    return http.post("/resource/add", data);
  }

  book(data) {
    return http.post("/resource/book", data);
  }

  release(data) {
    return http.delete("/resource/release", data);
  }

}

export default new BookingResourceService();
