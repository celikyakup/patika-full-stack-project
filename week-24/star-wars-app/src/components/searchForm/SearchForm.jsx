import { useFormik } from "formik";
import "./SearchForm.css"

// eslint-disable-next-line react/prop-types
const SearchForm = ({ query, setQuery }) => {
  const formik = useFormik({
    initialValues: {
      name: query,
    },
    onSubmit: (values) => {
      setQuery(values.name);
      console.log(values.name);
      formik.resetForm();
    },
  });

  return (
    <div className="form-con">
      <form onSubmit={formik.handleSubmit}>
        <label htmlFor="name">Name/Model </label>
        <input
          type="text"
          name="name"
          id="name"
          value={formik.values.name}
          placeholder="Name/Model"
          onChange={formik.handleChange}
        />
      </form>
      <div className="line"></div>
    </div>
  );
};

export default SearchForm;
