import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';

function ColorSchemesExample() {
  return (
    <>
      <Navbar>
        <Container>
          <Navbar.Brand href="#home"><img src="/necessary-documents/photos/logo.png" alt="" /></Navbar.Brand>
          <Nav>
            <Nav.Link href="#home">Home</Nav.Link>
            <Nav.Link href="#features">Classes</Nav.Link>
            <Nav.Link href="#pricing">Trainer</Nav.Link>
            <Nav.Link href="#pricing">Review</Nav.Link>
            <Nav.Link href="#pricing">Contact</Nav.Link>
            <Nav.Link href="#pricing" style={{}}>Join Us</Nav.Link>
          </Nav>
        </Container>
      </Navbar>
    </>
    
  );
}

export default ColorSchemesExample;