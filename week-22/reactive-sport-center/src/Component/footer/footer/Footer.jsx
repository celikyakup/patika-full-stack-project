import "./footer.css"

const Footer = () => {
  return (
    <section className="footer">
      <img src="necessary-documents/photos/logo.png" alt="" />
      <p>
        Lorem ipsum dolor sit amet consectetur adipisicing elit. Harum
        dignissimos corrupti doloremque consectetur quod deleniti?
      </p>
      <div className="footer-list">
        <div className="info">
          <h1>Information</h1>
          <ul className="footer-ul">
            <li>
              <a href="">About Us</a>
            </li>
            <li>
              <a href="">Classes</a>
            </li>
            <li>
              <a href="">Blog</a>
            </li>
            <li>
              <a href="">Contact</a>
            </li>
          </ul>
        </div>
        <div className="help">
          <h1>Helpful Links</h1>
          <ul className="footer-ul">
            <li>
              <a href="">Service</a>
            </li>
            <li>
              <a href="">Suppors</a>
            </li>
            <li>
              <a href="">Terms & Condition</a>
            </li>
            <li>
              <a href="">Privacy Policy</a>
            </li>
          </ul>
        </div>
      </div>
    </section>
  );
};

export default Footer;
