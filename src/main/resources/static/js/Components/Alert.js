const Alert = (title, text, icon) => {
  return Swal.fire({
    icon,
    title,
    text,
  });
};

Alert.confirm = (title, textButton = { si: "", no: "" }, callback, icon) => {
  return Swal.fire({
    icon,
    title: title,
    showCancelButton: true,
    confirmButtonText: textButton.si,
    cancelButtonText: textButton.no,
  }).then((result) => {
    if (result.isConfirmed) {
      callback();
    }
  });
};

export default Alert;
